package pl.tesseract.stan.web.selenium;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author Paweł Mielcarek
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class TrafficSpyTest {

    @Value("${bitbay.lisk.url}")
    private String liskUrl;

    @Value("${bitbay.response.filter}")
    private String requestUrlFilter;

    @Autowired
    private TrafficSpy trafficSpy;

    @Test
    public void captureTrafficTest() throws InterruptedException, IOException {
        trafficSpy.spyOn(liskUrl, requestUrlFilter);
    }
}
