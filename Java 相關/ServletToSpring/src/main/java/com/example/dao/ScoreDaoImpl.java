package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDaoImpl implements ScoreDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * Pageable: getPageSize 每頁顯示幾筆？ getOffset 移動到第幾筆開始計算
	 */
	@Override
	public List<Score> findScoresByPage(Pageable page) {
		String sql = "SELECT studentId, studentName, chinese, english, math, science, social FROM web.score Limit ? Offset ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Score.class), page.getPageSize(),page.getOffset());
	}

	/**
	 * 取得總頁數。例如：51筆資料，如果每頁顯示10筆，則共有6頁。
	 */
	@Override
	public int totalPage(int pageSize) {
		String sql = "SELECT CEIL(COUNT(1) / ?) AS total FROM score;";
		return jdbcTemplate.queryForObject(sql, Integer.class,pageSize);
	}

}
