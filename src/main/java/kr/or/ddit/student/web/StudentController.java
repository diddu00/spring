package kr.or.ddit.student.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/student")
@Controller("studentController")
public class StudentController {

	@Resource(name="studentService")
	private StudentServiceInf studentService;
	
	//학생 리스트 처리
	@RequestMapping("/list")
	public String studentList(@RequestParam(value="page", defaultValue="1")int page,
							  @RequestParam(value="pageSize",defaultValue="10")int pageSize,
							  Model model){
	HashMap<String, Integer> paramMap = new HashMap<String, Integer>();
	paramMap.put("page",page);
	paramMap.put("pageSize", pageSize);
//	public String studentList(@RequestParam Map<String, Integer> map, Model model){
		
		Map<String,Object> resultMap=studentService.getStudentPageList(paramMap);
		
		model.addAllAttributes(resultMap);
		
		
		return "student/list";
	}
	
	//localhost:8180/student/list/json?page=1&pageSize=10
	//학생 리스트 처리 JSON--------------------------------------------------------------------------------------------
	//ajax 요청을 위한 json 응답
		@RequestMapping("/list/json")
		@ResponseBody
		public Map<String,Object> studentJsonList(@RequestParam(value="page", defaultValue="1")int page,
								  @RequestParam(value="pageSize",defaultValue="10")int pageSize,
								  Model model){
		HashMap<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page",page);
		paramMap.put("pageSize", pageSize);
//		public String studentList(@RequestParam Map<String, Integer> map, Model model){
			
			Map<String,Object> resultMap=studentService.getStudentPageList(paramMap);
			
			return resultMap;
		}
		
		//-------------------------------------------------------------------------------------------------
		
	
	@RequestMapping("/detail")
	public String detail(StudentVo stdVo, Model model){
		
		StudentVo studentVo = studentService.getStudent(stdVo);
		
		model.addAttribute("studentVo",	studentVo);
		
		
		
		return "student/detail";
	}
	
	//////////////////////////////]타일 연습
	
	@RequestMapping("/tiles/list")
	public String studentTilesList(@RequestParam(value="page", defaultValue="1")int page,
							  @RequestParam(value="pageSize",defaultValue="10")int pageSize,
							  Model model){
	HashMap<String, Integer> paramMap = new HashMap<String, Integer>();
	paramMap.put("page",page);
	paramMap.put("pageSize", pageSize);
//	public String studentList(@RequestParam Map<String, Integer> map, Model model){
		
		Map<String,Object> resultMap=studentService.getStudentPageList(paramMap);
		
		model.addAllAttributes(resultMap);
		
		
		return "list";
	}
	
	
	
	
	
	@RequestMapping("/tiles/detail")
	public String tilesDetail(StudentVo stdVo, Model model){
		
		StudentVo studentVo = studentService.getStudent(stdVo);
		
		model.addAttribute("studentVo",	studentVo);
		
		
		
		return "detail";
	}
	
	
}
