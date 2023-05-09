package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class OrderCompleted extends AbstractEvent {

    private Long id;
    private Long customerId;
    private String productId;
    private String productName;
    private Integer qty;

    public OrderCompleted(Order aggregate) {
        super(aggregate);
    }

    public OrderCompleted() {
        super();
    }
}
