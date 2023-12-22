package org.cdri;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class YahooFinance {

	private final static String STOCK_CURRENT_API_URL = "https://query1.finance.yahoo.com/v7/finance/download/%s";

	private final static String STOCK_HISTORY_API_URL = "https://query1.finance.yahoo.com/v7/finance/download/%s?period1=%s&period2=%s&interval=1d&events=history";

	private final static String blueColor = "\033[1;34m";

	private final static String resetColor = "\033[0m";

	public static void main(String[] args) throws ParseException, ClientProtocolException, IOException {

		System.setProperty("stock.current.api.url", "https://query1.finance.yahoo.com/v7/finance/download/%s");

		System.setProperty("stock.history.api.url",
				"https://query1.finance.yahoo.com/v7/finance/download/%s?period1=%s&period2=%s&interval=1d&events=history");

		try {
			System.out.println(YahooFinance.getLatestStockData("0050.TW")); // 今日交易紀錄
			System.out.println(YahooFinance.getLatestStockData("0050.TW", "1D")); // 最近一日的每日交易紀錄
			System.out.println(YahooFinance.getLatestStockData("0050.TW", "1W")); // 最近一周的每日交易紀錄
//			System.out.println(YahooFinance.getLatestStockData("0050.TW", "1M")); // 最近一月的每日交易紀錄
//			System.out.println(YahooFinance.getLatestStockData("0050.TW", "2S")); // 最近一季的每日交易紀錄
//			System.out.println(YahooFinance.getLatestStockData("0050.TW", "1Y")); // 最近一年的每日交易紀錄

		} catch (IOException | RangeFormatException e) {
			e.printStackTrace();
		}
	}

	private static void validateRange(String range) throws RangeFormatException {

		if (range == null)
			throw new RangeFormatException(String.format("range is null", null));

		if (range.length() < 2)
			throw new RangeFormatException(String.format("range is invalid.", null));

		// 單位檢查
		String unitString = range.substring(range.length() - 1).toUpperCase();
		TimeUnit[] units = TimeUnit.values();
		boolean flag = Arrays.asList(units).stream().anyMatch(unit -> unit.name().equals(unitString));
		if (!flag) {
			throw new RangeFormatException("range is invalid. The valid unit is in [Y,W,M,S]");
		}

		// 數值檢查
		String numberString = range.substring(0, range.length() - 1).toUpperCase();
		try {
			Integer.parseInt(numberString);
		} catch (Exception e) {
			throw new RangeFormatException(String.format("range is invalid. %s is not number", numberString));
		}

		TimeUnit unit = Arrays.asList(units).stream().filter(u -> u.name().equals(unitString)).findAny().orElse(null);
		int number = Integer.parseInt(numberString);

		if (number < 1) {
			throw new RangeFormatException(String.format("range is invalid. %s is is not more than 1 ", numberString));
		}

	}

	/**
	 * 
	 * @param stockNo: 股票號碼
	 * @param range:   時間區間。例如：1D、1W、1M、1S、1Y
	 * @return
	 * @throws IOException
	 * @throws RangeFormatException
	 */
	public static String getLatestStockData(String stockNo, String range) throws IOException, RangeFormatException {

		validateRange(range);

		String unitString = range.substring(range.length() - 1).toUpperCase();
		String numberString = range.substring(0, range.length() - 1).toUpperCase();

		TimeUnit[] units = TimeUnit.values();
		TimeUnit unit = Arrays.asList(units).stream().filter(u -> u.name().equals(unitString)).findAny().get();
		int number = Integer.parseInt(numberString);

		return getLatestStockData(stockNo, unit, number);
	}

	/**
	 * 
	 * @param stockNo: 股票號碼
	 * @param unit:    TimeUnit 列舉
	 * @return
	 * @throws IOException
	 * @throws RangeFormatException
	 */
	public static String getLatestStockData(String stockNo, TimeUnit unit) throws IOException, RangeFormatException {
		return getLatestStockData(stockNo, unit, 1);
	}

	/**
	 * 
	 * @param stockNo: 股票號碼
	 * @param unit:    TimeUnit 列舉
	 * @param number:  區間範圍
	 * @return
	 * @throws IOException
	 * @throws RangeFormatException
	 */
	public static String getLatestStockData(String stockNo, TimeUnit unit, int number)
			throws IOException, RangeFormatException {

		validateRange(String.valueOf(number) + unit.name());

		LocalDate endDate = LocalDate.now();
		LocalDate startDate = null;

		if (unit.equals(TimeUnit.Y)) {
			startDate = endDate.minusYears(number);
		} else if (unit.equals(TimeUnit.W)) {
			startDate = endDate.minusWeeks(number);
		} else if (unit.equals(TimeUnit.M)) {
			startDate = endDate.minusMonths(number);
		} else if (unit.equals(TimeUnit.D)) {
			startDate = endDate.minusDays(number);
		} else if (unit.equals(TimeUnit.S)) {
			int month = endDate.getMonthValue(); // 1-12
			Season season = getLatestSeason(month);
			startDate = LocalDate.of(endDate.getYear(), season.getStartMonth(), 1);
			startDate = startDate.minusMonths((number - 1) * 3);
		}

		return getStockData(stockNo, startDate, endDate);
	}

	private static Season getLatestSeason(int month) {
		if (month >= 1 && month <= 3) {
			return Season.FIRST;
		} else if (month >= 4 && month <= 6) {
			return Season.SECOND;
		} else if (month >= 7 && month <= 9) {
			return Season.THRID;
		} else if (month >= 10 && month <= 12) {
			return Season.FOURTH;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param stockNo: 股票號碼
	 * @return
	 * @throws IOException
	 */
	public static String getLatestStockData(String stockNo) throws IOException {
		return getStockData(stockNo);
	}

	/**
	 * 
	 * @param stockNo: 股票號碼:0050.TW
	 * @param startDate: 起始日期:2023-12-01
	 * @param endDate: 結束日期:2023-12-31
	 * @return
	 * @throws IOException
	 */
	public static String getStockData(String stockNo, String startDateString, String endDateString) throws IOException {
		LocalDate endDate = LocalDate.parse(endDateString);
		LocalDate startDate = LocalDate.parse(startDateString);
		return getStockData(stockNo, startDate, endDate);
	}

	/**
	 * 
	 * @param stockNo: 股票號碼
	 * @param startDate: 起始日期
	 * @param endDate: 結束日期
	 * @return
	 * @throws IOException
	 */
	public static String getStockData(String stockNo, LocalDate startDate, LocalDate endDate) throws IOException {
		// 將開始和結束日期轉換為 Unix 時間戳（秒為單位）
		long period1 = startDate.atStartOfDay(ZoneId.of("UTC")).toEpochSecond();
		long period2 = endDate.atStartOfDay(ZoneId.of("UTC")).toEpochSecond();
		String url = String.format(
				System.getProperty("stock.history.api.url") != null ? System.getProperty("stock.history.api.url")
						: STOCK_HISTORY_API_URL,
				stockNo, period1, period2);
		System.out.printf("%s%n", blueColor + url + resetColor);
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(url);
			String csvData = EntityUtils.toString(httpClient.execute(request).getEntity());
			// �N CSV �ഫ�� JSON
			String json = convertCsvToJson(csvData);
			System.out.printf("%s%n", blueColor + json + resetColor);
			return json;
		}
	}

	/**
	 * 
	 * @param stockNo: 股票號碼
	 * @return
	 * @throws IOException
	 */
	public static String getStockData(String stockNo) throws IOException {
		// 將開始和結束日期轉換為 Unix 時間戳（秒為單位）
		String url = String.format(
				System.getProperty("stock.current.api.url") != null ? System.getProperty("stock.current.api.url")
						: STOCK_CURRENT_API_URL,
				stockNo);
		System.out.printf("%s%n", blueColor + url + resetColor);
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(url);
			String csvData = EntityUtils.toString(httpClient.execute(request).getEntity());
			// �N CSV �ഫ�� JSON
			String json = convertCsvToJson(csvData);
			System.out.printf("%s%n", blueColor + json + resetColor);
			return json;
		}
	}

	// CSV 轉 Json
	private static String convertCsvToJson(String csvData) throws IOException {
		try (CSVParser parser = CSVParser.parse(csvData, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
			List<Map<String, String>> records = new ArrayList<>();
			for (CSVRecord record : parser) {
				Map<String, String> map = new HashMap<>();
				record.toMap().forEach(map::put);
				records.add(map);
			}
			if (records.size() == 1) {
				return new Gson().toJson(records.get(0));
			} else {
				return new Gson().toJson(records);
			}
		}
	}
}
