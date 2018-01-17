package pl.tesseract.stan.web.bitbay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.tesseract.stan.model.StockGraph;

/**
 * @author Paweł Mielcarek
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BitBaySpyTest {

    @Autowired
    private BitBaySpy bitBaySpy;

    @Test
    public void spyTest() {
        StockGraph stockGraph = bitBaySpy.spyOnLisk();
        stockGraph.getPoints().forEach(p -> System.out.println(p));
    }
}
