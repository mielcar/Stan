package pl.tesseract.stan.model.bitbay;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Paweł Mielcarek
 */
@Data
public class BBGraphItem {
    LocalDateTime time;
    BBGraphPoint point;
}
