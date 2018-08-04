package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;

@Service("lprodService")
public class LprodService implements LprodServiceInf{
	LprodDaoInf lprodDao = new LprodDao();
	
	@Override
	public Map<String, Object> getLpordPageList(Map<String, Integer> map) {
		List<LprodVo> lprodPageList =lprodDao.getLpordPageList(map);
		int totCnt = lprodDao.getLprodTotCnt();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lprodPageList", lprodPageList);
		resultMap.put("totCnt", totCnt);
		String pageNavi = makePageNavi(totCnt, map);
		resultMap.put("pageNavi", pageNavi);
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
		
		pageNavi.append("<li><a href=\"/lprod/list?page="+(activePage>1?activePage-1:1)+"&pageSize=10\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		for(int i =1;i<=pagingnationSize;i++){
			String activeClass = "";
			if(i==activePage)
				activeClass = " class=\"active\"";
//			}else{
//				activeClass="";	=> 요딴거 할 필요가없음.. 맨위에서 초기화 다시하니까
//			}
		
			pageNavi.append("<li"+activeClass+"><a href=\"/lprod/list?page="+i+"&pageSize=10\">"+i+"</a></li>");
		}
	    pageNavi.append("<li><a href=\"/lprod/list?page="+(activePage<pagingnationSize?activePage+1:pagingnationSize)+"&pageSize=10\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
	    return pageNavi.toString();
	}

}
