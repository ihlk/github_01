package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user=new Users();
	//用户登录动作
	public String login(){
		UsersDAO udao=new UsersDAOImpl();
		if(udao.usersLogin(user)){
			//在session中保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else{
			return "login_failure";
		}
	}
	//用户注销功能
	@SkipValidation
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	

	public void validate() {
		// TODO Auto-generated method stub
		//验证用户名不能为空
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空");
		}
		//验证密码不少于6位
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "密码不能少于6位");
		}
		
	}
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
}
