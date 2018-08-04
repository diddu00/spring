package kr.or.ddit.studentDaoTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	private StudentDaoInf studentDao;
	
	//@Before -> @Test (test()끼리는 실행순서가 따로 없다.)-> @After
	//테스트 메서드안에서 중복되는 내용 : StudentDao 구현체에 대한 생성로직
	// --> @Before 어노테이션이 붙은 setup()에 위임
	//모든 테스트 메소드에서 StudentDao 객체를 참조할 수 있게끔 클래스 변수로 생성할 피룡가 있고
	//클래스 변수를 setup()에서 초기화 하는 로직이 필요
	@Before
	public void setup(){
		studentDao = new StudentDao(); 
	}
	/**
	 * 
	* Method : selectAllStudentsTest
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* Method 설명 : 전체 학생 정보를 조회한다. 
	 */
	@Test
	public void selectAllStudentsTest() {
		/***Given***/
		

		/***When***/
		List<StudentVo> studentList = studentDao.selectAllStudents();
		
		for (StudentVo studentVo : studentList) {
			System.out.println(studentVo);
		}
		
		/***Then***/
		assertEquals(25, studentList.size());

	}
	
	@Test
	public void getStudentTest(){
		/***Given***/
		int id = 9;
		StudentVo vo = new StudentVo();
		vo.setId(8);
	
		/***When***/
		StudentVo studentVo = studentDao.getStudent(id);	//getStudentById
		StudentVo studentVo2 = studentDao.getStudent(vo);	//getStudentByVo
		System.out.println(studentVo);
		System.out.println(studentVo2);
		
		/***Then***/
		assertEquals("차득림", studentVo.getName());
		assertEquals("양관모", studentVo2.getName());
	}
	
	@Test
	public void getStudentPageListTest(){
		/***Given***/
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 3);
		map.put("pageSize", 10);

		/***When***/
		List<StudentVo> pageList = studentDao.getStudentPageList(map);
		
		/***Then***/
		assertEquals(5, pageList.size());
	}
	
	@Test
	public void getStudentListSizeTest(){
		/***Given***/
		

		/***When***/
		int studentListSize = studentDao.getStudentListSize();
		int pagingnationSize = studentListSize%10==0?studentListSize/10:studentListSize/10+1;
		/***Then***/
		assertEquals(25, studentListSize);
		assertEquals(3, pagingnationSize);
		
	}

	@Test
	public void studentUpdateTest(){
		/***Given***/
		StudentVo studentVo = studentDao.getStudent(2);
		studentVo.setAdd1("충남 서산시 지곡면 외양골길 5");
		/***When***/
		int cnt = studentDao.studentUpdate(studentVo);
		/***Then***/
		assertEquals(1, cnt);

	}
}
