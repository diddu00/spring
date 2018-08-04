package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodServiceInf {
	/**
	 * 
	* Method : getLpordPageList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC11
	* 변경이력 :
	* @return
	* Method 설명 : 해당page와 pageSize를 가져와 정보를 조회하는 메서드
	 */
	Map<String, Object> getLpordPageList(Map<String, Integer> map);
	
	
}
