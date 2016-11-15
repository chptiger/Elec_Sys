package junit;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.xx.elec.domain.ElecText;

/**
 * 
 * @author xin
 *
 */
public class TestHibernate {
	// test save()
	@Test
	public void save(){
		Configuration configuration =  new Configuration();
		configuration.configure(); // load hibernate.cfg.xml file under classpath
		SessionFactory sf = configuration.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		ElecText eleText = new ElecText();
		eleText.setTextName("Save");
		eleText.setTextDate(new Date());
		eleText.setTextRemark("test hibernate save method ");
		
		s.save(eleText);
		tr.commit();
		s.close();
		
	}
}
