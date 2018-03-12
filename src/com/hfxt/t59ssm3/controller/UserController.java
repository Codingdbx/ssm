package com.hfxt.t59ssm3.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hfxt.t59ssm3.service.RoleService;
import com.hfxt.t59ssm3.service.UserService;
import com.hfxt.t59ssm3.util.Page;
import com.hfxt.t59ssm3.domain.Role;
import com.hfxt.t59ssm3.domain.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String doLogin(User user,HttpSession session,HttpServletResponse response){
		user = userService.checkLogin(user.getUsername(), user.getPassword());
		if(user!=null){
			
			Cookie cookie = new Cookie("username","dbx");
			cookie.setPath("/t59ssm3/");
			cookie.setMaxAge(3600*24);
			response.addCookie(cookie);//返回客户端 
			//然后我们就可以使用${cookie.username}获得这个cookie了，${cookie.username.name}获得cookie名称，${cookie.username.value}获得cookie值。
			
			
			session.setAttribute("loginUser", user);
			/*return "redirect:userList";*/
			return "redirect:getUserListByPage";
		}else{
			return "login";
		}
	}
	
	@RequestMapping("/userList")
	public String getAllUsers(Model model){
		List<User> users=userService.getAllUsers();
		model.addAttribute("users",users);
		return "index";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(int id,HttpSession session){
		int row=userService.deleteUser(id);
		if(row>0){
			session.setAttribute("msg", "删除成功!");
			return "redirect:getUserListByPage";
		}else{
			return "login";
		}
		
	}
	
	@RequestMapping("/getAllRoleName")
	public String getAllRoleName(Model model){
		List<Role> roles=roleService.getAllRoleName();
		model.addAttribute("roles",roles);
		return "addUser";
		
	}
	
	@RequestMapping("/addUser")
	public String addUser(String username,String password,Integer status,Integer roleId,Model model){
		
		 User user=new User();
		 user.setUsername(username);
		 user.setPassword(password);
		 user.setStatus(status);
		 user.setRoleId(roleId);
		 
	     userService.addUser(user);
	     
	     return "redirect:getUserListByPage";
	 
		
	}
	
	@RequestMapping("/getUserInfoById")
	public String getUserInfoById(int id,Model model){
		User user=userService.getUserInfoById(id);
		model.addAttribute("user", user);
		List<Role> roles=roleService.getAllRoleName();
		model.addAttribute("roles",roles);
		
		return "updateUser";
		
		
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(Integer id,String username,String password,Integer status,Integer roleId,Model model){
		User user=new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setStatus(status);
		user.setRoleId(roleId);
		user.setId(id);
		
		int row = userService.updateUser(user);
		if(row>0){
			return "redirect:getUserListByPage";
		}else{
			return "login";
		}
	}
	
	@RequestMapping("/getUserListByConditon")
	public String getUserListByConditon(String username,String password,Integer status,Model model){
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(status);
		
		
		
		User condition=new User();
	    condition.setUsername(username);
	    condition.setPassword(password);
	    condition.setStatus(status);
	    
	    List<User> users=userService.getUserListByConditon(condition);
	    model.addAttribute("users",users);
	    
	    return "index";
	}
	
	
	
	@RequestMapping("/getUserListByPage")
	public String getUserListByPage(String username,String password,Integer status,String pageIndex,String pageSize,Model model){
		Page page=new Page();
		
		//验证:第一次进来，pageIndex是为空的，即按照page的初始值分页
		if(pageIndex!=null&&!"".equals(pageIndex)){
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
	    if(pageSize!=null&&!"".equals(pageSize)){
			page.setPageSize(Integer.parseInt(pageSize));
		}
	    
	    User condition=new User();
	    condition.setUsername(username);
	    condition.setPassword(password);
	    condition.setStatus(status);
	    
	    int totalCount=userService.getTotalCount(condition);
		page.setTotalCount(totalCount);
	    
	    
	   
	    /*Map<Page,User> map=new HashMap<Page, User>();
	    map.put(page, condition);*/
	    
	    List<User> users=userService.getUserListByPage(condition,page);
	    
	    /*List<User> users=userService.getUserListByPage(page.getPageIndex(),page.getPageSize(),condition);*/
	   /* List<User> users=userService.getUserListByPage(page.getPageIndex(), page.getPageSize(),condition.getStatus(),condition.getUsername(), 
	    		condition.getPassword());*/
	    
	    model.addAttribute("users",users);
	    model.addAttribute("page", page);
	    model.addAttribute("condition", condition);
		return "index";
	    
		
	}
	
}
