package tk.chuanjing.ssh_xml;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tk.chuanjing.ssh_xml.domain.User;
import tk.chuanjing.ssh_xml.service.IUserService;

/**
 * @author ChuanJing
 * @date 2017年7月24日 下午8:30:52
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void testAdd() {
		User user = new User();
		user.setName("tom");
		user.setAge(20);
		
		userService.add(user);
	}

	@Test
	public void testUpdate() {
		User user = userService.findById(2);
		user.setName("露露");
		
		userService.update(user);
	}

	@Test
	public void testDel() {
		User user = userService.findById(2);
		userService.del(user);
	}

	@Test
	public void testFindById() {
		User user = userService.findById(1);
		System.out.println(user);
	}

	@Test
	public void testFindAll() {
		List<User> list = userService.findAll();
		System.out.println(list);
	}
	
	@Test
	public void testfindAllByCriteria() {
		// 1.创建一个DetachedCriteria
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.gt("age", 10)); // >10
		List<User> list = userService.findAllByCriteria(dc);
		System.out.println(list);
	}
	
	@Test
	public void testfindByNameQuery() {
		List<User> list = userService.findByNameQuery();
		System.out.println(list);
	}

}
