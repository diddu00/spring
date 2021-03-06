package kr.or.ddit.ioc.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	
	private List lists;
	private Set sets;
	private Map maps;
	private Properties pros;
	
	//spring 설정 파일을 통해서 주입해주는 방법
	//1. 생성자를 통한 주입
	//2. set,get method를 이용한 주입 
	public List getLists() {
		return lists;
	}
	public void setLists(List lists) {
		this.lists = lists;
	}
	public Set getSets() {
		return sets;
	}
	public void setSets(Set sets) {
		this.sets = sets;
	}
	public Map getMaps() {
		return maps;
	}
	public void setMaps(Map maps) {
		this.maps = maps;
	}
	public Properties getPros() {
		return pros;
	}
	public void setPros(Properties pros) {
		this.pros = pros;
	}
	
	
	

}
