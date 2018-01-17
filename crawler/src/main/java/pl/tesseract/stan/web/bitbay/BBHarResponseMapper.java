package pl.tesseract.stan.web.bitbay;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.lightbody.bmp.core.har.HarResponse;
import org.springframework.stereotype.Component;
import pl.tesseract.stan.model.StockGraph;
import pl.tesseract.stan.model.bitbay.BBGraphItem;
import pl.tesseract.stan.model.bitbay.BBGraphPoint;
import pl.tesseract.stan.model.bitbay.BBGraphResponse;
import pl.tesseract.stan.model.bitbay.StockGraphMapper;
import pl.tesseract.stan.util.DateUtil;

import java.io.IOException;

/**
 * @author Paweł Mielcarek
 */
@Component
public class BBHarResponseMapper {

    public static StockGraph map(HarResponse response) {
        StockGraph stockGraph = new StockGraph();
        if (response == null || response.getContent() == null) return stockGraph;
        try {
            BBGraphResponse bbGraphResponse = new ObjectMapper().readValue(response.getContent().getText(), BBGraphResponse.class);
            bbGraphResponse.getItems().forEach(items -> {
                BBGraphItem bbGraphItem = new BBGraphItem();
                bbGraphItem.setDate(DateUtil.getDateTimeFromTimestamp(Long.valueOf((String)items.get(0))));
                bbGraphItem.setPoint(new ObjectMapper().convertValue(items.get(1), BBGraphPoint.class));
                stockGraph.getPoints().add(StockGraphMapper.mapBBItem(bbGraphItem));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stockGraph;
    }
}
