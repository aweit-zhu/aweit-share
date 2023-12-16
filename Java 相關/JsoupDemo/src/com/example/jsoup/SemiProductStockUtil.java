package com.example.jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Component;

import com.example.bean.SemiProductStock;

@Component
public class SemiProductStockUtil {

	/**
	 * 半導體產業漲跌排行
	 * @return
	 * @throws IOException
	 */
	public List<SemiProductStock> getSemiProductStocks() throws IOException {
		
		String url = "https://tw.stock.yahoo.com/quote/2330.TW";
        Document doc = Jsoup.connect(url).get();
        
        Element aside3 = doc.getElementById("aside-3-RelatedStockList-Proxy");
        		
        Elements list = aside3.select("div.table-body.Pos\\(r\\).Bxz\\(bb\\) > div > div > ul > li");
        
        List<SemiProductStock> semiProducts = new ArrayList<>();
        
        list.forEach( li -> {
        	Element stockName = li.selectFirst("div.Ell.Fz\\(14px\\).Fw\\(600\\).Lh\\(1\\.25\\).Whs\\(n\\).LineClamp\\(2\\,40px\\)");
        	Element stockNumber = li.selectFirst("div.C\\(\\$c-fuji-grey-j\\).Mt\\(4px\\).Ell.Fz\\(11px\\).Lh\\(12px\\).Pend\\(0px\\)");
        	Element priceDiv = li.selectFirst("span.Jc\\(fe\\).Fz\\(14px\\)");
        	Element priceChangeDiv = li.selectFirst("span.Jc\\(fe\\).Fw\\(n\\).D\\(f\\).Ai\\(c\\)");
        	Element tradingDiv = li.select("span.Jc\\(fe\\).Fz\\(14px\\)").get(1);
        	
        	System.out.format("股名:%-3s,股號:%-7s,股價:%-4s,漲跌:%-4s,成交量(張):%s%n", 
        			stockName.text(),stockNumber.text(),priceDiv.text(),priceChangeDiv.text(),tradingDiv.text());
        	semiProducts.add(
        		SemiProductStock.builder()
        			.stockName(stockName.text())
        			.stockNumber(stockNumber.text())
        			.price(priceDiv.text())
        			.priceChange(priceChangeDiv.text())
        			.trading(tradingDiv.text())
        			.build()
        	);
        });

		return semiProducts;
	}
}
