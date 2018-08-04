package kr.or.ddit.student.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

@Repository("studentDao")
public class StudentDao implements StudentDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Resource(name="studentDao")
	private StudentDaoInf studentDao;
	
	//session 객체는 메소드 실행시마다 해줘야 되기때문에 공유해서 쓸 수 없다.
	/**
	 * 
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();  // -> 요것을 해줘야됨 그래서 따로 변수에 담아서 리턴을 하는것임 
		
		return studentList;
	}


	/**
	 * 
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 학생의 id를 매개변수로 받아 해당 학생을 조회
	 */
	@Override
	public StudentVo getStudent(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.getStudentById", id);
		session.close();
		return studentVo;
	}


	/**
	 * 
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 해당 학생의VO로 id를 받아 해당 학생을 조회 
	 */
	@Override
	public StudentVo getStudent(StudentVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.getStudentByVo", vo);
		session.close();
		return studentVo;
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
	public List<StudentVo> getStudentPageList(Map<String, Integer> page) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentPageList", page);
		session.close();
		return studentList;
	}
	
	/**
	 * 
	* Method : getStudentListSize
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 모든 회원의 수를 반환하는 메서드 
	 */
	@Override
	public int getStudentListSize(){
		SqlSession session = sqlSessionFactory.openSession();
		int pagingnationSize = session.selectOne("student.getStudentListSize");
		session.close();
		return pagingnationSize;
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
		SqlSession session = sqlSessionFactory.openSession();
		int cnt=session.update("student.studentUpdate", studentVo);
		session.commit();
		session.close();
		return cnt;
	}

}
