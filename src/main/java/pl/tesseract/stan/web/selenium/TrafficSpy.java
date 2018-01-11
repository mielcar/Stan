package pl.tesseract.stan.web.selenium;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarResponse;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import pl.tesseract.stan.model.bitbay.BBGraphResponse;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * @author Paweł Mielcarek
 */
@Component
public class TrafficSpy {

    @Autowired
    protected Environment env;

    public static BrowserMobProxyServer server;
    public static WebDriver driver;

    @PostConstruct
    private void init() {
        System.setProperty("webdriver.chrome.driver", new File(env.getRequiredProperty("selenium.test.chromedriver.location")).getAbsolutePath());
        server = new BrowserMobProxyServer();
        server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        server.start();
        int port = server.getPort();
        Proxy proxy = ClientUtil.createSeleniumProxy(server);
        DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
        seleniumCapabilities.setCapability(CapabilityType.PROXY, proxy);
        driver = new ChromeDriver(seleniumCapabilities);
        System.out.println("Port started:" + port);
    }

    public HarResponse spyOn(String siteUrl, String requestUrl) throws InterruptedException, IOException {
        server.newHar("test.har");
        driver.get(siteUrl);
        driver.manage().window().maximize();
        Thread.sleep(15000);
        return captureTrafficData(requestUrl);
    }

    private HarResponse captureTrafficData(String urlFilter) throws IOException {
        Har har = server.getHar();
        driver.quit();
        server.stop();
        for (HarEntry entry : har.getLog().getEntries()) {
            if (entry.getResponse() != null ) {
                HarResponse response = entry.getResponse();
                String responseUrl = entry.getRequest().getUrl();
                if(responseUrl.contains(urlFilter) && response.getContent().getText()!= null){
                    return response;
                }
            }

        }
        return null;
    }

}
