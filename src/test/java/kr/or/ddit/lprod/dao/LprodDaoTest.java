package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;

public class LprodDaoTest {
	private LprodDaoInf lprodDao;
	
	@Before
	public void setup(){
		lprodDao = new LprodDao();
	}
	/**
	 * 
	* Method : selectAllLprodsTest
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC11
	* 변경이력 :
	* Method 설명 : 모든 lprod의 정보를 조회 테스트 
	 */
	@Test
	public void selectAllLprodsTest() {
		/***Given***/
		
		
		/***When***/
		List<LprodVo> lprodList = lprodDao.selectAllLprods();
		for (LprodVo lprodVo : lprodList) {
			System.out.println(lprodVo);
		}
		/***Then***/
		assertEquals(13, lprodList.size());
	}
	
	/**
	 * 
	* Method : getLpordPageList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 해당page와 pageSize를 가져와 정보를 조회하는 메서드 테스트
	 */
	@Test
	public void getLprodPageListTest(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 2);
		map.put("pageSize", 10);
		/***When***/
		List<LprodVo> lprodPageList = lprodDao.getLpordPageList(map);
		/***Then***/
		assertEquals(3, lprodPageList.size());

	}

	/**
	 * 
	* Method : getLprodTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : lprod의 전체 갯수를 반환하는 메서드 
	 */
	@Test
	public void getLprodTotCntTest(){
		/***Given***/
		
		/***When***/
		int totCnt = lprodDao.getLprodTotCnt();
		/***Then***/
		assertEquals(13, totCnt);

	}

}
