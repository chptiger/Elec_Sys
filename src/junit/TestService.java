package junit;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xx.elec.domain.ElecText;
import com.xx.elec.service.IElecTextService;

/**
 * 
 * @author xin
 *
 */
public class TestService{ 
	
	@Test
	public void save(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextService elecTextService = (IElecTextService)ac.getBean(IElecTextService.SERVICE_NAME);
		
		ElecText elecText = new ElecText();
		elecText.setTextName("Save sevice");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("test service save method ");
		
		elecTextService.saveElecText(elecText);
	}
	
	// Monitor action tier， test underlying method with search conditions, show result list
	@Test
	public void findCollectionByConditionNoPage(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextService elecTextService = (IElecTextService)ac.getBean(IElecTextService.SERVICE_NAME);
		
		//result in model driven
		ElecText elecText = new ElecText();
		elecText.setTextName("save");
		elecText.setTextRemark("11102016");     
		List<ElecText> list = elecTextService.findCollectionByConditionNoPage(elecText);
		
		if( list!=null && list.size()!=0){
			for( ElecText text:list){
				System.out.println( text.getTextName() + " " + text.getTextRemark());
			}
		}
	}
}