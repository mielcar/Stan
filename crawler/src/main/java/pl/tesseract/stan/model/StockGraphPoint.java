package pl.tesseract.stan.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * @author Paweł Mielcarek
 */
@Data
@Embeddable
public class StockGraphPoint {
   private Double open;
   private Double close;
   private Double high;
   private Double low;
   private Double volume;
   private LocalDateTime date;
}
