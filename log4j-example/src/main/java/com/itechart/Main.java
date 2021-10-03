package com.itechart;


public class Main {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        for (int i = 0; i < 100; i++) {
            orderService.createOrder();
            orderService.payForOrder();
            orderService.checkOrderStatus();
        }
    }
}
