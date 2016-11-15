package junit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xx.elec.dao.IElecTextDao;
import com.xx.elec.domain.ElecText;

/**
 * 
 * @author xin
 *
 */
public class TestDao{
	
	@Test
	public void save(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao)ac.getBean(IElecTextDao.SERVICE_NAME);
		
		ElecText elecText = new ElecText();
		elecText.setTextName("Save");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("test dao save method 11102016 ");
		
		elecTextDao.save(elecText);
	}
	
	@Test
	public void update(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao)ac.getBean(IElecTextDao.SERVICE_NAME);
		
		ElecText elecText = new ElecText();
		elecText.setTextID("40284781537a358e01537a358f120000");
		elecText.setTextName("Update");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("test update 11112016");
		
		elecTextDao.update(elecText);
	}
	
	@Test
	public void findObjectById(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao)ac.getBean(IElecTextDao.SERVICE_NAME);
		
		Serializable id = "40284781537a358e01537a358f120000"; 
		ElecText elecText = elecTextDao.findObjectById(id);
		System.out.println(elecText.getTextName() + " " + elecText.getTextRemark());
	}
	
	@Test
	public void deleteObjectByIds(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao)ac.getBean(IElecTextDao.SERVICE_NAME);
		Serializable[] ids = {"40284781538794140153879416920000", "402847815387afa7015387afa8b90000"};
		elecTextDao.deleteObjectByIds(ids);
		
	}
	
	@Test
	public void deleteObjectByCollection(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao)ac.getBean(IElecTextDao.SERVICE_NAME);
		List<ElecText> list = new ArrayList<ElecText>();
		
		ElecText elecText1 = new ElecText();
		elecText1.setTextID("402847815387ac01015387ac028d0000");
		
		ElecText elecText2 = new ElecText();
		elecText2.setTextID("40284781539c75c601539c75c7550000");
		
		list.add(elecText1);
		list.add(elecText2);
		System.out.println(list.toString());
		elecTextDao.deleteObjectByCollection(list);
	}
}