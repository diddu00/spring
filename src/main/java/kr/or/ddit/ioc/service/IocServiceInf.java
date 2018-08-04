package kr.or.ddit.ioc.service;

import kr.or.ddit.ioc.dao.IocDaoInf;

public interface IocServiceInf {
	String hello();
	
	void setIocDao(IocDaoInf iocDao);
	public IocDaoInf getIocDao() ;

}
