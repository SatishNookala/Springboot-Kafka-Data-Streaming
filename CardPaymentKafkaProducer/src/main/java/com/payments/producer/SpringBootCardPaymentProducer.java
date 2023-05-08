package com.payments.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringBootCardPaymentProducer implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCardPaymentProducer.class, args);
    }

    @Autowired
    private CardPaymentProducer cardPaymentProducer;

    @Override
    public void run(String... args) throws Exception {
        cardPaymentProducer.sendMessage();
    }
}
