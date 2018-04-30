package pl.tesseract.stan.domain;

import lombok.Data;
import pl.tesseract.stan.model.StockGraph;
import pl.tesseract.stan.model.StockGraphPoint;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class BitBayPoint {

    @Id
    private Long id;

    @Embedded
    private StockGraphPoint stockGraphPoint;

}
