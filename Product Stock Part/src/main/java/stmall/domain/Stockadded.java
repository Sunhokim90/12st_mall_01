package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class Stockadded extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;

    public Stockadded(Inventory aggregate) {
        super(aggregate);
    }

    public Stockadded() {
        super();
    }
}
