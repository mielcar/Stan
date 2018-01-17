package pl.tesseract.stan.model.bitbay;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Paweł Mielcarek
 */
@Data
public class BBGraphPoint {
    private Double o;
    private Double c;
    private Double h;
    private Double l;
    private Double v;
    private LocalDateTime date;
}
