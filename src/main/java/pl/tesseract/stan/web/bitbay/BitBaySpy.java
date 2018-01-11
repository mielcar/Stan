package pl.tesseract.stan.web.bitbay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.tesseract.stan.model.StockGraph;
import pl.tesseract.stan.web.selenium.TrafficSpy;

import java.io.IOException;

/**
 * @author Paweł Mielcarek
 */
@Component
public class BitBaySpy {

    private TrafficSpy trafficSpy;

    @Value("${bitbay.lisk.url}")
    private String liskUrl;

    @Value("${bitbay.response.filter}")
    private String requestUrlFilter;

    @Autowired
    public BitBaySpy(TrafficSpy trafficSpy) {
        this.trafficSpy = trafficSpy;
    }

    public StockGraph spyOnLisk() {
        StockGraph stockGraph = null;
        try {
            stockGraph = BBHarResponseMapper.map(trafficSpy.spyOn(liskUrl, requestUrlFilter));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return stockGraph;
    }

}
