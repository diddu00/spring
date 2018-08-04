package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceInf;


@WebServlet("/lprodList")
public class LprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LprodServiceInf lprodService = new LprodService();
		String pageStr=request.getParameter("page");
		int page = pageStr==null?1:Integer.parseInt(pageStr);
		request.setAttribute("page", page);
		
		String pageSizeStr=request.getParameter("pageSize");
		int pageSize = pageSizeStr==null?1:Integer.parseInt(pageSizeStr);  
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", page);
		map.put("pageSize",pageSize);
		
		Map<String, Object> resultMap = lprodService.getLpordPageList(map);
		List<LprodVo> lprodPageList = (List<LprodVo>)resultMap.get("lprodPageList");
		int totCnt = (int)resultMap.get("totCnt");
		int pagingnationSize = totCnt%pageSize==0?totCnt/pageSize:totCnt/pageSize+1;
		request.setAttribute("lprodPageList", lprodPageList);
		request.setAttribute("pagingnationSize", pagingnationSize);
		request.setAttribute("pageNavi", resultMap.get("pageNavi"));
		request.getRequestDispatcher("/lprod/lprodList.jsp").forward(request, response);
		
	}


}
