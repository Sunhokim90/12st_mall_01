package stmall.domain;

import java.util.*;
import lombok.Data;
import stmall.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long OrderID;
    private String ProductID;
    private String ProductName;
    private Integer qty;
    private String status;
}
