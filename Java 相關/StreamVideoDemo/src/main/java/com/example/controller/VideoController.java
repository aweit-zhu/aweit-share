package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@GetMapping()
    public String getVideo() {
        return "forward:/WEB-INF/videos/video.mp4";
    }
}
