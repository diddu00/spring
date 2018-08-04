package kr.or.ddit.lprod.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.lprod.service.LprodServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lprod")
@Controller
public class LprodController {
	
	@Resource(name="lprodService")
	LprodServiceInf lprodService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",defaultValue="1")int page, 
					   @RequestParam(value="pageSize",defaultValue="10")int pageSize,
					   Model model
					   ){
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		Map<String, Object> resultMap=lprodService.getLpordPageList(paramMap);
		
		model.addAllAttributes(resultMap);
		
		return "lprod/lprodList";
	}
	
	
}
