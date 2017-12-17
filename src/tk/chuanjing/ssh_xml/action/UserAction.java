package tk.chuanjing.ssh_xml.action;

import tk.chuanjing.ssh_xml.domain.User;
import tk.chuanjing.ssh_xml.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author ChuanJing
 * @date 2017年7月25日 下午3:09:11
 * @version 1.0
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	
	private IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public User getModel() {
		return user;
	}

	public String add() {
		userService.add(user);
		
		return SUCCESS;
	}

}
