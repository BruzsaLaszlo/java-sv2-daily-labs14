package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderService {

    private final List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrderByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .toList();
    }

    public long countByOrderStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .count();
    }

    public List<Order> getOrdersBetween(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(order -> !order.getOrderDate().isBefore(from)
                        && !order.getOrderDate().isAfter(to))
                .toList();
    }

    public boolean isOrderWithLessProduct(int maxCount) {
        return orders.stream()
                .anyMatch(order -> order.getProducts().size() < maxCount);
    }

    public Order getOrderWithMostProduct() {
        return orders.stream()
                .max(Comparator.comparing(order -> order.getProducts().size()))
                .orElseThrow(IllegalArgumentException::new);
    }

}
