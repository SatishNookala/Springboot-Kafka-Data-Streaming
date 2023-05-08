package com.payments.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class CardPaymentProducer {
    private static Logger logger = LoggerFactory.getLogger(CardPaymentProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    public CardPaymentProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage() throws InterruptedException {
        String topic = "card_payment_info";
        // to read real time stream data from wikimedia we use event source
        EventHandler eventHandler = new CardPaymentEventHandler(kafkaTemplate,topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource =builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);

    }
}
