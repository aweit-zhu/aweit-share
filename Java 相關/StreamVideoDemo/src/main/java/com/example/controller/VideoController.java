package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@GetMapping("/v1")
    public String getVideo() {
        return "forward:/WEB-INF/videos/video.mp4";
    }
	
	@GetMapping("/v2")
	@ResponseBody 
	public FileSystemResource getVideo(HttpServletRequest request) {
		String videoPath = request.getSession().getServletContext().getRealPath("/WEB-INF/videos/video.mp4");
	    return new FileSystemResource(videoPath);
	}
}
