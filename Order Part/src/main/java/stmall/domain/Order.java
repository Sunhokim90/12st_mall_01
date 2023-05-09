package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.OrderPartApplication;
import stmall.domain.OrderCompleted;
import stmall.domain.Ordercancled;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long customerId;

    private String productId;

    private String productName;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        OrderCompleted orderCompleted = new OrderCompleted(this);
        orderCompleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        Ordercancled ordercancled = new Ordercancled(this);
        ordercancled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderPartApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void waitingUser(Stockadded stockadded) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(stockadded.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void updateStatus(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void updateStatus(DeliveryCancled deliveryCancled) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCancled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
