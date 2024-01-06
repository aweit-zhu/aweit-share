package com.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * http://localhost:9090/mvc/upload
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

	private static final String UPLOAD_DIR = "C:/uploads/";
	
	@PostMapping
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        // 確保上傳的檔案不為空
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {
        	
            // 獲取檔案名稱
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // 檢查檔案名稱是否包含無效字符等
            if (fileName.contains("..")) {
                return ResponseEntity.badRequest().body("Invalid file name");
            }

            // 構建目標路徑
            Path targetPath = Path.of(UPLOAD_DIR + fileName);

            // 將檔案保存到目標路徑
            // Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            file.transferTo(targetPath); // 將檔案直接保存到目標路徑，而不是臨時目錄

            // 返回成功訊息
            return ResponseEntity.ok("File uploaded successfully!");

        } catch (IOException e) {
            // 處理異常情況
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload the file");
        }
    }
}
