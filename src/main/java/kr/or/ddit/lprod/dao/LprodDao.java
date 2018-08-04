package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;


public class LprodDao implements LprodDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * 
	* Method : selectAllLprods
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 모든 lprod의 정보를 조회하여 반환하는 메서드
	 */
	@Override
	public List<LprodVo> selectAllLprods() {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = session.selectList("lprod.selectAllLprods");
		session.close();
		return lprodList;
	}

	@Override
	public List<LprodVo> getLpordPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = session.selectList("lprod.getLpordPageList",map);
		session.close();
		return lprodList;
	}

	@Override
	public int getLprodTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int totCnt = session.selectOne("lprod.getLprodTotCnt");
		session.close();
		
		return totCnt;
	}

}
