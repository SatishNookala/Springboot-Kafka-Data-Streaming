package com.payments.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(CardPaymentConsumer.class);

    @KafkaListener(topics = "card_payment_info", groupId = "Payments")
    public void consumeCardPaymentInfo(String eventMessage) {
        LOGGER.info("Event Message Received : {}", eventMessage);
    }
}
