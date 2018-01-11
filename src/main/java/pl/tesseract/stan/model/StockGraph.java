package pl.tesseract.stan.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Paweł Mielcarek
 */
@Data
public class StockGraph {

    private LocalDateTime beginning;

    private LocalDateTime end;

    private Double minPrice;

    private Double maxPrice;

    private List<StockGraphPoint> points;
}
