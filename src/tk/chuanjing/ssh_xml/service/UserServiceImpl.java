package tk.chuanjing.ssh_xml.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import tk.chuanjing.ssh_xml.dao.IUserDAO;
import tk.chuanjing.ssh_xml.domain.User;

/**
 * @author ChuanJing
 * @date 2017年7月24日 下午8:26:03
 * @version 1.0
 */
public class UserServiceImpl implements IUserService {

//	@Autowired
	private IUserDAO userDao;
	
	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public void add(User user) {
		userDao.add(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void del(User user) {
		userDao.del(user);
	}

	public User findById(int id) {
		return userDao.findById(id);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public List<User> findAllByCriteria(DetachedCriteria dc) {
		return userDao.findAllByCriteria(dc);
	}

	public List<User> findByNameQuery() {
		return userDao.findByNameQuery();
	}

}
