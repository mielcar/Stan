package pl.tesseract.stan.model.bitbay;

import lombok.Data;

import java.util.List;

/**
 * @author Paweł Mielcarek
 */
@Data
public class BBGraphResponse {
    private String status;
    private List<List<Object>> items;
}
