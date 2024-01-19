package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.Score;
import com.example.dao.ScoreDao;

/**
 * http://localhost:8080/ServletToSpring/mvc/score
 */
@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	ScoreDao scoreDao;
	
	@GetMapping
	public String socrePage(Model model, 
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage) {
		
		int totalPage = scoreDao.totalPage(10); // 算出總頁數
		
		Pageable page = PageRequest.of((currentPage-1), 10); // 0:第一頁(1-1=0) 10:每頁幾筆
		List<Score> scores = scoreDao.findScoresByPage(page);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("scores", scores);
		
		return "score_list";
	}
}
