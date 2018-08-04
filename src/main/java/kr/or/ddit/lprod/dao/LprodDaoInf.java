package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodDaoInf {
	/**
	 * 
	* Method : selectAllLprods
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 모든 lprod의 내용을 조회하여 반환하는 메서드
	 */
	List<LprodVo> selectAllLprods();
	
	/**
	 * 
	* Method : getLpordPageList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 해당page와 pageSize를 가져와 정보를 조회하는 메서드
	 */
	List<LprodVo> getLpordPageList(Map<String, Integer> map);
	
	/**
	 * 
	* Method : getLprodTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : lprod의 전체 갯수를 반환하는 메서드 
	 */
	int getLprodTotCnt();
}
