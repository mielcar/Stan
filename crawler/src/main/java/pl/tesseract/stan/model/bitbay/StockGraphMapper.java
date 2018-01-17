package pl.tesseract.stan.model.bitbay;

import pl.tesseract.stan.model.StockGraphPoint;

/**
 * @author Paweł Mielcarek
 */
public class StockGraphMapper {

    public static StockGraphPoint mapBBItem(BBGraphItem item) {
        StockGraphPoint stockGraphPoint = new StockGraphPoint();
        stockGraphPoint.setDate(item.getDate());
        BBGraphPoint bbPoint = item.getPoint();
        stockGraphPoint.setClose(bbPoint.getC());
        stockGraphPoint.setOpen(bbPoint.getO());
        stockGraphPoint.setHigh(bbPoint.getH());
        stockGraphPoint.setLow(bbPoint.getL());
        stockGraphPoint.setVolume(bbPoint.getV());
        return stockGraphPoint;
    }
}
