package kr.or.ddit.ioc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.ioc.dao.IocDao;
import kr.or.ddit.ioc.dao.IocDaoInf;

@Service("iocAnnotationService")
public class IocAnnotationService implements IocServiceInf{

	@Resource(name="iocDao")
	private IocDaoInf iocDao;
	
	public IocAnnotationService() {
		
	}

	
	//setter를 통한 주입
	public void setIocDao(IocDaoInf iocDao) {
		this.iocDao = iocDao;
	}
	
	
	public IocDaoInf getIocDao() {
		return iocDao;
	}

	@Override
	public String hello() {
		return iocDao.hello();
	}

	


}
