package pl.tesseract.stan.web.selenium;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author Paweł Mielcarek
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrafficSpyTest {

    @Autowired
    private TrafficSpy trafficSpy;

    @Test
    public void captureTrafficTest() throws InterruptedException, IOException {
        trafficSpy.spyOn("https://bitbay.net/pl/kurs-walut/kurs-lisk-pln", "/rest/trading/candle/history/");
    }
}
