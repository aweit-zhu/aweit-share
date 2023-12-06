import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 即期匯率(美元):https://www.esunbank.com/zh-tw/personal/deposit/rate/forex/foreign-exchange-rates
 * */
public class JsoupTest2 {

	public static void main(String[] args) {
		try {
			String url = "https://www.esunbank.com/zh-tw/personal/deposit/rate/forex/foreign-exchange-rates";
			Document doc = Jsoup.connect(url).get();
			Element element  = doc.selectFirst("#exchangeRate > table > tbody > tr.px-3.py-2.p-lg-0.USD.currency > td:nth-child(2) > div.BBoardRate");
			System.out.println(element.text());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
