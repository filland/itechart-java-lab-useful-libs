package com.itechart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderService {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    public void createOrder() {
        logger.info("creating a new order: orderId=123, userId=342");
    }

    public void payForOrder() {
        logger.info("paying for the order: orderId=123, userId=342");
        calculateTotalPrice();
        doPaying();
    }

    public void checkOrderStatus() {
        logger.info("checking order status: orderId=123, userId=342");
    }

    private void doPaying() {
        try {
            // logic for transferring money from user's card to shop's bank account
            if (true) {
                throw new RuntimeException();
            }
            logger.debug("payment was successful: orderId=123");
        } catch (Throwable e) {
            logger.error("payment failed: orderId=123", e);
        }
    }

    private void calculateTotalPrice() {
        logger.debug("calculating total price for order: orderId=123");
    }
}
