package kr.or.ddit.student.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

public interface StudentDaoInf {
	/**
	 * 
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생의 정보를 조회한다 
	 */
	List<StudentVo> selectAllStudents();

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
	StudentVo getStudent(int id);
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
	StudentVo getStudent(StudentVo vo);
	
	
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
	List<StudentVo> getStudentPageList(Map<String, Integer> page);
	
	/**
	 * 
	* Method : getStudentListSize
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 모든 회원의 수를 반환하는 메서드 
	 */
	int getStudentListSize();
	
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
	int studentUpdate(StudentVo studentVo);
}
