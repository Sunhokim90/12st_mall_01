package stmall.domain;

import java.util.*;
import lombok.Data;
import stmall.infra.AbstractEvent;

@Data
public class OrderCompleted extends AbstractEvent {

    private Long id;
    private Long CustomerID;
    private String ProductID;
    private String ProductName;
    private Integer qty;
}
