package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.SemiProductStock;

@Repository
public class SemiProductStockDaoImpl implements SemiProductStockDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SemiProductStock> findLatestSemiProductStock() {
		
		String sql = "select v.trx_id, v.stockName, v.stockNumber, v.price, v.priceChange, v.trading, v.createDate from ( "
				+ "	SELECT trx_id, stockName, stockNumber, price, priceChange, trading, createDate, "
				+ "	RANK() OVER ( ORDER BY trx_id desc) as rk  "
				+ "	FROM web.SemiProductStock "
				+ ") v where v.rk = 1 order by v.price desc";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(SemiProductStock.class));
	}

}
