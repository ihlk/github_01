package action;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Students;

import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

//学生Action类
public class StudentsAction extends SuperAction{

	//查询所有学生动作
	public String query(){
		StudentsDAO sdao=new StudentsDAOImpl();
		List<Students> list=sdao.queryAllStudents();
		//放进session中
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
			//return "Students_query_success";
		}
		return "query_success";
	}
	//删除学生动作
	public String delete(){
		StudentsDAO sdao=new StudentsDAOImpl();
		String sid=request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
		
	}
	//添加学生
	public String add() throws Exception{
		Students s=new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao=new StudentsDAOImpl();
		sdao.addStudents(s);
		return "add_success";
		
	}
	//修改学生信息动作
	public String modify(){
		
		//获得传递过来的学生编号
		String sid=request.getParameter("sid");
		StudentsDAO sdao=new StudentsDAOImpl();
		Students s=sdao.queryStudentsById(sid);
		//保存在会话中
		session.setAttribute("modify_students",s);
		return "modify_success";
	}
	//保存修改学生信息动作
	public String save() throws Exception{
		Students s=new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao=new StudentsDAOImpl();
		sdao.updateStudents(s);
		return "save_success";
	}
	public String find(){
		String sid=request.getParameter("sid");
		StudentsDAO sdao=new StudentsDAOImpl();
		Students s=sdao.queryStudentsById(sid);
		//保存到会话中
		session.setAttribute("modify_students", s);
		return "find_success";
	}
}





