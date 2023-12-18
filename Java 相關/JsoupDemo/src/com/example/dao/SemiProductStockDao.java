package com.example.dao;

import java.util.List;

import com.example.bean.SemiProductStock;

public interface SemiProductStockDao {

	public final String NEXT_SEQ_SQL = "SELECT NEXTVAL('semi_product_stock_trx_seq')";
	
	int getNextSeq();
	
	int[] save(List<SemiProductStock> semiProductStocks);
}
