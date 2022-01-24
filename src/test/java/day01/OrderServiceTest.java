package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 6, 7));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p5);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);

        Order o3 = new Order("pending", LocalDate.of(2021, 6, 7));
        o3.addProduct(p1);
        o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o4.addProduct(p3);
        o4.addProduct(p1);
        o4.addProduct(p2);

        Order o5 = new Order("pending", LocalDate.of(2021, 6, 7));
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p3);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void findOrderByStatus() {
        assertEquals(3, orderService.findOrderByStatus("pending").size());
    }

    @Test
    void countByOrderStatus() {
        assertEquals(3, orderService.countByOrderStatus("pending"));
    }

    @Test
    void getOrdersBetween() {
        assertEquals(3, orderService.getOrdersBetween(
                LocalDate.of(2021, 6, 7),
                LocalDate.of(2021, 6, 7)).size());
    }

    @Test
    void hasOrderLessProduct() {
        assertTrue(orderService.isOrderWithLessProduct(3));
        assertFalse(orderService.isOrderWithLessProduct(2));
    }

    @Test
    void getOrderWithMostProduct() {
        assertEquals(4, orderService.getOrderWithMostProduct().getProducts().size());

        var osWithEmptyProductList = new OrderService();
        assertThrows(IllegalArgumentException.class, osWithEmptyProductList::getOrderWithMostProduct);
    }
}