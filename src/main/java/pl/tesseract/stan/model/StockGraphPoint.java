package pl.tesseract.stan.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Paweł Mielcarek
 */
@Data
public class StockGraphPoint {

    private Double price;

    private LocalDateTime date;
}
