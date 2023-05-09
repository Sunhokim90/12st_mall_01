package stmall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmall.config.kafka.KafkaProcessor;
import stmall.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Stockadded'"
    )
    public void wheneverStockadded_WaitingUser(@Payload Stockadded stockadded) {
        Stockadded event = stockadded;
        System.out.println(
            "\n\n##### listener WaitingUser : " + stockadded + "\n\n"
        );

        // Sample Logic //
        Order.waitingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_UpdateStatus(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCancled'"
    )
    public void wheneverDeliveryCancled_UpdateStatus(
        @Payload DeliveryCancled deliveryCancled
    ) {
        DeliveryCancled event = deliveryCancled;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliveryCancled + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
