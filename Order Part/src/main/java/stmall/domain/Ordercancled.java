package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class Ordercancled extends AbstractEvent {

    private Long id;
    private Long customerId;
    private String productId;
    private String productName;
    private Integer qty;

    public Ordercancled(Order aggregate) {
        super(aggregate);
    }

    public Ordercancled() {
        super();
    }
}
