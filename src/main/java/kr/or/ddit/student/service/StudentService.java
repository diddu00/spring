package kr.or.ddit.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

@Service("studentService")
public class StudentService implements StudentServiceInf{
//	private StudentDaoInf studentDao = new StudentDao();
	
	@Resource(name="studentDao")
	private StudentDaoInf studentDao;
	/**
	 * 
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 모든 학생들의 정보를 조회하는 메서드 
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		return studentDao.selectAllStudents();
	}

	/**
	 * 
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 해당 학생의 id를 매개변수로 받아 한 학생을 조회
	 */
	@Override
	public StudentVo getStudent(int id) {
		return studentDao.getStudent(id);
	}

	
	/**
	 * 
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 해당 학생의 VO로 id를 받아 한 학생을 조회
	 */
	@Override
	public StudentVo getStudent(StudentVo vo) {
		return studentDao.getStudent(vo);
	}
	
	
	/**
	 * 
	* Method : pagingStudentbyPage
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 해당 페이지 * pageSize 를 매개변수로 받아 페이지에 맞는 회원정보만을 가져오는 메서드 
	 */
	@Override
	public Map<String,Object> getStudentPageList(Map<String, Integer> page) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		//학생 페이지 리스트 조회
		List<StudentVo> studentList = studentDao.getStudentPageList(page);
		resultMap.put("studentList", studentList);
		//학생 전체 건수 조회
		int totCnt = studentDao.getStudentListSize();
		resultMap.put("totCnt", totCnt);

		resultMap.put("pageNavi", makePageNavi(totCnt,page));
		return resultMap;
	}
	/**
	 * 
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC11
	* 변경이력 :
	* @param totCnt
	* @param page
	* @return
	* Method 설명 : 페이지 네이게이션  문자열 생성 
	 */
	private String makePageNavi(int totCnt,Map<String, Integer> page){
		//페이지 네이게이션 html 생성 
		int activePage = page.get("page");
		int pageSize = page.get("pageSize");
		
		int pagingnationSize = totCnt%pageSize==0?totCnt/pageSize:totCnt/pageSize+1;
		
		StringBuilder pageNavi = new StringBuilder();
		
		pageNavi.append("<li data-page=\""+(activePage>1?activePage-1:1)+"\"><a href=\"/student/list?page="+(activePage>1?activePage-1:1)+"&pageSize=10\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		for(int i =1;i<=pagingnationSize;i++){
			String activeClass = "";
			if(i==activePage)
				activeClass = " class=\"active\"";
//			}else{
//				activeClass="";	=> 요딴거 할 필요가없음.. 맨위에서 초기화 다시하니까
//			}
		
			pageNavi.append("<li data-page=\""+i+"\" "+activeClass+"><a href=\"/student/list/json?page="+i+"&pageSize=10\">"+i+"</a></li>");
		}
	    pageNavi.append("<li data-page=\""+(activePage>1?activePage-1:1)+"\"><a href=\"/student/list/json?page="+(activePage<pagingnationSize?activePage+1:pagingnationSize)+"&pageSize=10\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
	    return pageNavi.toString();
	}
	
	/**
	 * 
	* Method : studentUpdate
	* 최초작성일 : 2018. 7. 17.
	* 작성자 : PC11
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : 학생 정보 업데이트
	 */
	@Override
	public int studentUpdate(StudentVo studentVo) {
		return studentDao.studentUpdate(studentVo);
	}
	
}
