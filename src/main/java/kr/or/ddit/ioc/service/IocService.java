package kr.or.ddit.ioc.service;

import kr.or.ddit.ioc.dao.IocDao;
import kr.or.ddit.ioc.dao.IocDaoInf;

public class IocService implements IocServiceInf{
	private IocDaoInf iocDao;
	
	
	
	public IocService() {
		
	}

	//생성자를 통한 주입 (iocDao 객체 주입)
	public IocService(IocDaoInf iocDao) {
		this.iocDao = iocDao;
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
