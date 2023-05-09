package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class StockDeleted extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;

    public StockDeleted(Inventory aggregate) {
        super(aggregate);
    }

    public StockDeleted() {
        super();
    }
}
