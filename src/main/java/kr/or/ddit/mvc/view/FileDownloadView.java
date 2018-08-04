package kr.or.ddit.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kr.or.ddit.util.FileUtil;

import org.springframework.web.servlet.View;

public class FileDownloadView implements View{

	@Override
	public String getContentType() {
		return "application/vnd.ms-excel; charset=UTF-8";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String fileName = request.getParameter("fileName");
		response.setHeader("Content-Disposition", "attachment; filename="+fileName);
		response.setContentType("application/octet-stream");
		
		
		//D:\A_TeachingMaterial\7.JspSpring\fileUpload\sally.png
		String file = FileUtil.fileUploadPath+File.separator+fileName;
		
		//file 입출력을 위한 준비
		//outputStream
		ServletOutputStream sos = response.getOutputStream();
		
		//inputStream
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b =new byte[512];
		int len = 0;
		
		//읽고 쓰고
		while((len=fis.read(b))!=-1){
			sos.write(b,0,len);
		}
		
		//입출력 닫아주기 
		sos.close();
		fis.close();
		
		   
		   
	}

}
