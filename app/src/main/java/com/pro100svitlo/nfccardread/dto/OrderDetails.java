package com.pro100svitlo.nfccardread.dto;

import java.util.Objects;

public class OrderDetails {
    private String tableId;
    private Server server;
    private Customer customer;
    private Restaurant restaurant;
    private Order order;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails orderDetails = (OrderDetails) o;
        return Objects.equals(getTableId(), orderDetails.getTableId()) &&
                Objects.equals(getServer(), orderDetails.getServer()) &&
                Objects.equals(getCustomer(), orderDetails.getCustomer()) &&
                Objects.equals(getRestaurant(), orderDetails.getRestaurant()) &&
                Objects.equals(getOrder(), orderDetails.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTableId(), getServer(), getCustomer(), getRestaurant(), getOrder());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDetails{");
        sb.append("tableId='").append(tableId).append('\'');
        sb.append(", server=").append(server);
        sb.append(", customer=").append(customer);
        sb.append(", restaurant=").append(restaurant);
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
