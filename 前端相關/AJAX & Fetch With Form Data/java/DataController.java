import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

/**
 * http://localhost:8080/ServletToSpring/mvc/data
 * http://localhost:8080/ServletToSpring/mvc/data2
 */
@RestController
public class DataController {

	@PostMapping(value = "/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map postData(@RequestParam(value = "file", required = false) List<MultipartFile> files,@RequestParam Map data) {
		
		if(files!=null) {
			files.stream().forEach(file-> System.out.println(file.getOriginalFilename()));
		} else {
			System.out.println("無上傳檔案");
		}

		return data;
	}
	
	@PostMapping(value = "/data2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Result postData2(@RequestParam Map data) {
		return Result.builder()
				.status(1)
				.message(data.toString())
				.date(new Date())
				.build();
	}
}

@Data
@Builder
class Result {
	
	Integer status;
	
	String message;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	java.util.Date date;
}