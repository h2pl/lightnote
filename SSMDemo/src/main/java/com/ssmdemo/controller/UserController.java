package com.ssmdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssmdemo.entity.User;
import com.ssmdemo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	/**
     * 用户信息列表
     * @return
     * 如果采用JSON传值，那么需要注释掉下方方法中的代码
     * List<User> userList = userService.findAll();
     * mv.addObject("userList", userList);
     * 直接返回一个空视图名称
     * 页面异步加载数据，请查看下方注释方法
     */
	@RequestMapping(value = "/userList")
	public ModelAndView userList(){
		List<User> userList = userService.findAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("userList");
		
		return mv;
	}
	/**
     * 用户信息列表   页面异步加载
     * @return
     * @ResponseBody 注解的作用是将目标类型数据转换成json格式
     * 另外页面需要加入jquery js
     */
	/*@RequestMapping(value = "/list")
	public @ResponseBody List<User> list(){
		List<User> userList = userService.findAll();
		return userList;
	}
	*/
	
	/**
     * 跳转到添加信息视图
     * @return
     */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add");
		return mv;
	}
	/**
     * 添加信息
     * @param user
     * @return
     */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String add(User user){
		userService.add(user);
		return "redirect:/user/userList";
	}
	/**
     * 修改信息获取，跳转到修改信息视图
     * @param id
     * @return
     */
	@RequestMapping(value = "/editLoad")
	public ModelAndView editLoad(@RequestParam(value = "id") Integer id){
		User user = userService.findByID(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("edit");
		return mv;
	}
	/**
     * 修改信息
     * @param user
     * @return
     */
	@RequestMapping(value = "/edit",method = RequestMethod.POST)
	public String edit(User user){
		userService.update(user);
		return "redirect:/user/userList";
	}
	/**
     * 删除用户
     * @param id
     * @return
     */
	@RequestMapping(value = "/delete")
	public String  delete(@RequestParam(value = "id") Integer id){
		userService.delete(id);
		
		return "redirect:/user/userList";
	}
	
	
	
	
	
	
	
}
