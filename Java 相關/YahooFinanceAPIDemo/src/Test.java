import java.io.IOException;

import org.cdri.YahooFinance;

public class Test {

	public static void main(String[] args) throws IOException {
        
		//System.setProperty("stock.api.url", "https://query1.finance.yahoo.com/v7/finance/download/%s?period1=%s&period2=%s&interval=1d&events=history");

		String dataString = YahooFinance.getStockData("0050.TW","2023-12-18","2023-12-19");
		
		System.out.println(dataString);
	}

}
