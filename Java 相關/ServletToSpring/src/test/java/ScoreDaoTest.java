
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.dao.Score;
import com.example.dao.ScoreDaoImpl;

public class ScoreDaoTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/springmvc-servlet.xml");
		
		ScoreDaoImpl scoreDaoImpl = ctx.getBean("scoreDaoImpl", ScoreDaoImpl.class);
		
		Pageable page = PageRequest.of(0, 10); // 0:頁數 10:每頁幾筆
		List<Score> scores = scoreDaoImpl.findScoresByPage(page);
		
		scores.stream().forEach(System.out::println);
		
		int totalPage = scoreDaoImpl.totalPage(10); // 算出幾頁
		System.out.println(totalPage);

	}

}
