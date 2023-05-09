package stmall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Productseach_table")
@Data
public class Productseach {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
