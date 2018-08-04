package kr.or.ddit.ioc.collection;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanTest {
	ApplicationContext context;
	
	@Before
	public void setup(){ //'classpath:' 안써도 굴러가는데?
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-collection.xml");
	}
	
	//spring container 정상 생성 확인
	@Test
	public void springContainterTest(){
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(context);
		assertTrue(context.getBeanDefinitionCount()>=1);
	}
	
	@Test
	public void listTest() {
		/***Given***/
		//spring ioc 컨테이너 생성(before)

		/***When***/
		//CollectionBean을 DL
		//CollectionBean객체의 getList()를 통해서 list객체 받기 
		//List객체 getter를 통해서 확인
//		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		CollectionBean collectionBean = context.getBean("collectionBean",CollectionBean.class);
		List lists = collectionBean.getLists();
		
		/***Then***/
		//List.get(0) == brown / List.get(1) == cony / List.get(2) == sally
		assertEquals("brown", lists.get(0));
		assertEquals("cony", lists.get(1));
		assertEquals("sally", lists.get(2));

	}
	
	@Test
	public void setTest(){
		/***Given***/
		//spring ioc 컨테이너 생성(before)

		/***When***/
		//CollectionBean을 DL
		//CollectionBean객체의 getList()를 통해서 list객체 받기 
		//List객체 getter를 통해서 확인
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		Set sets = collectionBean.getSets();
		Iterator iterator =sets.iterator();

		/***Then***/
		//brown, cony, sally
		assertEquals("cony", (String)iterator.next());
		assertEquals("sally", (String)iterator.next());
		assertEquals("brown", (String)iterator.next());
	}
	
	@Test
	public void mapTest(){
		/***Given***/
		

		/***When***/
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		Map maps = collectionBean.getMaps();
		/***Then***/
		assertEquals("sally", maps.get("ranger1"));
		assertEquals("brown", maps.get("ranger2"));
		assertEquals("cony", maps.get("ranger3"));

	}
	
	@Test
	public void prosTest(){
		/***Given***/
		
		
		/***When***/
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		Properties pros = collectionBean.getPros();
		/***Then***/
		assertEquals("brown", pros.get("ranger1"));
		assertEquals("cony", pros.get("ranger2"));
		assertEquals("sally", pros.get("ranger3"));

	}

}
