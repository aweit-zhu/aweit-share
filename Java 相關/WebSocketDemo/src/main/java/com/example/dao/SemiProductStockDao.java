package com.example.dao;

import java.util.List;

import com.example.entity.SemiProductStock;

public interface SemiProductStockDao {

	List<SemiProductStock> findLatestSemiProductStock();
}
