package cn.hnck.com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hnck.com.dao.impl.AddressDaoImpl;
import cn.hnck.com.entity.ShippingAddress;

public class AddressServiceImplTest {

	@SuppressWarnings("resource")
	@Test
	public void testAddAddress() {
		ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"spring.xml","hibernate.cfg.xml"});
		AddressDaoImpl bean = context.getBean(AddressDaoImpl.class);
		ShippingAddress spas = new ShippingAddress();
		

		spas.setRecipient("11111");
		spas.setMobilePhone("mobilePhone");
		spas.setAddress("address");
		spas.setDetailedAddress("detailedAddress");
		
		try {
			bean.AddAddress(spas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
