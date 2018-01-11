package pl.tesseract.stan.web.bitbay;

import net.lightbody.bmp.core.har.HarResponse;
import org.springframework.stereotype.Component;
import pl.tesseract.stan.model.StockGraph;

/**
 * @author Paweł Mielcarek
 */
@Component
public class BBHarResponseMapper {

    public static StockGraph map(HarResponse response) {
        StockGraph stockGraph = new StockGraph();

        return stockGraph;
    }
}
