package tk.chuanjing.ssh_xml.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import tk.chuanjing.ssh_xml.domain.User;

/**
 * @author ChuanJing
 * @date 2017年7月24日 下午7:26:18
 * @version 1.0
 */
public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {

//	private HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
	
	public void add(User user) {
		this.getHibernateTemplate().save(user);// session.save()
	}

	public void update(User user) {
		this.getHibernateTemplate().update(user);// session.update()
	}

	public void del(User user) {
		this.getHibernateTemplate().delete(user);// session.delete()
	}

	public User findById(int id) {
		return this.getHibernateTemplate().get(User.class, id);// session.get()
	}

	public List<User> findAll() {
		// 原来的hibernate中 session.createQuery(hql).setParameter().list();
		return (List<User>) this.getHibernateTemplate().find("from User");
	}

	public List<User> findAllByCriteria(DetachedCriteria dc) {
		return (List<User>) this.getHibernateTemplate().findByCriteria(dc);
	}

	public List<User> findByNameQuery() {
//		return (List<User>) this.getHibernateTemplate().findByNamedQuery("findUserByHQL", 1);
		return (List<User>) this.getHibernateTemplate().findByNamedQuery("findUserBySQL");
	}

}
