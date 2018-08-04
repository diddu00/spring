package kr.or.ddit.mvc.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import kr.or.ddit.util.FileUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequestMapping("/mvc")
@Controller("mvcController")
public class MvcController {
	
	Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	@ModelAttribute("boardList")		//@ReqestMapping보다 먼저 실행됨
	public List<String> boardList(){
		
		logger.debug("{}","boardList");
		//db에서 조회한 보드 리스트
		List<String>boardList = new ArrayList<String>();
		boardList.add("자유게시판");
		boardList.add("공지사항");
		boardList.add("Q&A게시판");
		
		
		return boardList;
	}
	
	
	
	//mvc 어노테이션을 테스트할 view
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(){
		
		return "mvc/view";
	}
	
	@RequestMapping(value="/view2", method=RequestMethod.GET)
	public String view2(){
		
		return "mvc/view2";
	}
	
	//@RequestParam : 특정 이름의 파라미터를 메소드 인자에서 받을 수 있다. 
	@RequestMapping(value="/requestParam", method=RequestMethod.GET) //get이나 post 안써있으면 둘다 받을 수있다. 하지만 이것을 지정을 할 수가 있습니다.
	public String requestParam(@RequestParam("std_id") String param){
		
		logger.debug("{}","param : "+param);
		
		return "mvc/view";
	}
	
	@RequestMapping(value="/pathvariable/{boardNum}")
	public String pathvariable(@PathVariable("boardNum") String boardNum, Model model){
		
		model.addAttribute("boardNum", boardNum);
		
		return "mvc/view";
	}
	
	//multipart test용 view
	@RequestMapping("/multipart/view")
	public String mutipartView(){
		
		return "mvc/multipartView";
	}
	
	
	@RequestMapping(value="/multipart/upload", method=RequestMethod.POST)
	public String multipartUpload(@RequestParam("userId")String userId,
								  FileVo files,
//								  @RequestPart("uploadFile")MultipartFile[] files,
//								  MultipartHttpServletRequest request,
								  Model model){
		
		logger.debug("{}","userId : "+userId);
//		logger.debug("{}","MultipartHttpServletRequest userId : "+request.getParameter("userId"));
		model.addAttribute("userId", userId);
		
		for (MultipartFile file : files.getFiles()) {
			logger.debug("{}","uploadFile.getName() : "+file.getName());
			logger.debug("{}","uploadFile.getOriginalFilename() : "+file.getOriginalFilename());
						
			String path = FileUtil.fileUploadPath;
			String fileName = UUID.randomUUID().toString();
			logger.debug("{}","fileName : "+fileName);
			File uploadFile = new File(path+File.separator+fileName);
			try {
				file.transferTo(uploadFile);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		return "mvc/multipartView";
	}
	
}
