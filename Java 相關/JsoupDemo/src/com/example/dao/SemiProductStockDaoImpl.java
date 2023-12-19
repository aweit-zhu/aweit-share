package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.bean.SemiProductStock;

@Component("semiProductStockDaoImpl")
public class SemiProductStockDaoImpl implements SemiProductStockDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public int[] save(List<SemiProductStock> semiProductStocks) {

		int trxId = getNextSeq();
		
		String sql = "INSERT INTO SemiProductStock(trx_id, stockName,stockNumber,price,priceChange,trading) VALUES (?, ?, ?, ?, ?, ?)";
		
		BatchPreparedStatementSetter bps = new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				SemiProductStock semiProductStock = semiProductStocks.get(i);
			    ps.setInt(1, trxId);
			    ps.setString(2, semiProductStock.getStockName());
			    ps.setString(3, semiProductStock.getStockNumber());
			    ps.setString(4, semiProductStock.getPrice());
			    ps.setString(5, semiProductStock.getPriceChange());
			    ps.setString(6, semiProductStock.getTrading());
			}

			@Override
			public int getBatchSize() {
				return semiProductStocks.size();
			}
			
		};
		
		return jdbcTemplate.batchUpdate(sql, bps);

	}

	@Override
	public int getNextSeq() {
		return jdbcTemplate.queryForObject(NEXT_SEQ_SQL, Integer.class);
	}

}
