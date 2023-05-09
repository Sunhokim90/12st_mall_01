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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCompleted'"
    )
    public void wheneverOrderCompleted_OrderComplete(
        @Payload OrderCompleted orderCompleted
    ) {
        OrderCompleted event = orderCompleted;
        System.out.println(
            "\n\n##### listener OrderComplete : " + orderCompleted + "\n\n"
        );

        // Comments //
        //1.CJ Logis send payload
        // 2. SMS to Customer
        // 3. Keeping to our DB

        // Sample Logic //
        Delivery.orderComplete(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordercancled'"
    )
    public void wheneverOrdercancled_Ordercancle(
        @Payload Ordercancled ordercancled
    ) {
        Ordercancled event = ordercancled;
        System.out.println(
            "\n\n##### listener Ordercancle : " + ordercancled + "\n\n"
        );

        // Sample Logic //
        Delivery.ordercancle(event);
    }
}
