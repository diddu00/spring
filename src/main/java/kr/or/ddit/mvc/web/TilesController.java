package kr.or.ddit.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/tiles")
@Controller
public class TilesController {
	
	@RequestMapping("/main")
	public String tilesMain(){
		return "main";
	}
	
}
