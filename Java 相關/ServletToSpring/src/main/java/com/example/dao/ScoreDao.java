package com.example.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface ScoreDao {

	List<Score> findScoresByPage(Pageable page);
	
	int totalPage(int pageSize);
}
