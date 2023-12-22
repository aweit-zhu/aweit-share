import java.io.IOException;

import org.cdri.RangeFormatException;
import org.cdri.TimeUnit;
import org.cdri.YahooFinance;

public class Test {

	// https://query1.finance.yahoo.com/v8/finance/chart/0050.TW
	
	// https://query1.finance.yahoo.com/v7/finance/download/%s
	
	// https://query1.finance.yahoo.com/v7/finance/download/%s?period1=%s&period2=%s&interval=1d&events=history
	
	public static void main(String[] args) throws IOException, RangeFormatException {
		
		System.setProperty("stock.api.url",
				"https://query1.finance.yahoo.com/v7/finance/download/%s");
		
		System.out.println(YahooFinance.getLatestStockData("0050.TW"));
		
//		System.setProperty("stock.api.url",
//				"https://query1.finance.yahoo.com/v7/finance/download/%s?period1=%s&period2=%s&interval=1d&events=history");
	
//		try {
//			
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", "1D")); // 最近一日的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", "1W")); // 最近一周的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", "1M")); // 最近一月的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", "1S")); // 最近一季的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", "1Y")); // 最近一年的每日交易紀錄
//
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.D)); // 最近一日的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.W)); // 最近一周的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.M)); // 最近一月的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.S)); // 最近一季的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.Y)); // 最近一年的每日交易紀錄
//
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.D, 2)); // 最近二日的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.W, 2)); // 最近二周的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.M, 2)); // 最近二月的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.S, 2)); // 最近二季的每日交易紀錄
////			System.out.println(YahooFinance.getLatestStockData("0050.TW", TimeUnit.Y, 2)); // 最近二年的每日交易紀錄
//
//		} catch (IOException | RangeFormatException e) {
//			e.printStackTrace();
//		} 
	}

}
