package stmall.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmall.config.kafka.KafkaProcessor;
import stmall.domain.*;

@Service
public class MypageViewHandler {

    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCompleted_then_CREATE_1(
        @Payload OrderCompleted orderCompleted
    ) {
        try {
            if (!orderCompleted.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setOrderId(orderCompleted.getId());
            mypage.setCustomerId(orderCompleted.getCustomerId());
            mypage.setProductName(orderCompleted.getProductName());
            mypage.setProductId(orderCompleted.getProductId());
            mypage.setQty(orderCompleted.getQty());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회

            List<Mypage> mypageList = mypageRepository.findByStatus(
                deliveryStarted.getStatus()
            );
            for (Mypage mypage : mypageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus(deliveryStarted.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCancled_then_UPDATE_2(
        @Payload DeliveryCancled deliveryCancled
    ) {
        try {
            if (!deliveryCancled.validate()) return;
            // view 객체 조회

            List<Mypage> mypageList = mypageRepository.findByOrderId(
                deliveryCancled.getOrderId()
            );
            for (Mypage mypage : mypageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setStatus(deliveryCancled.getStatus());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
