package com.lpt.servlet.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lpt.servlet.LoginServlet;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebClient;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.InvocationContext;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

/**
 * 
 * @author lpt
 * LoginServletTest
 * 登录测试类
 */
public class LoginServletTest {
	@Test
	public void testLoginServlet() throws Exception {
		// 创建Servlet的运行环境
		ServletRunner sr = new ServletRunner();
		// 向环境中注册Servlet
		sr.registerServlet("LoginServlet", LoginServlet.class.getName());
		// 创建访问Servlet的客户端
		ServletUnitClient client = sr.newClient();
		// 发送请求,并附带参数
		WebRequest loginRequest = new PostMethodWebRequest("http://localhost:8080/LoginServlet");
		loginRequest.setParameter("account", "admin");
		loginRequest.setParameter("password", "111111");
		loginRequest.setParameter("method", "Login");
		loginRequest.setParameter("type", "1");
		
		InvocationContext invocation = client.newInvocation(loginRequest);
		invocation.getServlet().service(invocation.getRequest(), invocation.getResponse());
		// 获得模拟服务器的信息
		WebResponse response = invocation.getServletResponse();
		// 将得到的结果赋予act实际结果
		String act = response.getText();
		System.out.println(act);
		//预期结果
		String exp = "admin";
		System.out.println(exp);
		// 预期结果与实际结果比较
		assertEquals("LoginServletTest",exp, act);
	}
	
	@Test
	public void testLoginServlet2() throws Exception {
		// 创建Servlet的运行环境
		ServletRunner sr = new ServletRunner();
		// 向环境中注册Servlet
		sr.registerServlet("LoginServlet", LoginServlet.class.getName());
		// 创建访问Servlet的客户端
		ServletUnitClient client = sr.newClient();
		// 发送请求,并附带参数
		WebRequest loginRequest = new PostMethodWebRequest("http://localhost:8080/LoginServlet");
		loginRequest.setParameter("account", "162056114");
		loginRequest.setParameter("password", "111111");
		loginRequest.setParameter("method", "Login");
		loginRequest.setParameter("type", "2");
		
		InvocationContext invocation = client.newInvocation(loginRequest);
		invocation.getServlet().service(invocation.getRequest(), invocation.getResponse());
		// 获得模拟服务器的信息
		WebResponse response = invocation.getServletResponse();
		// 将得到的结果赋予act实际结果
		String act = response.getText();
		System.out.println(act);
		//预期结果
		String exp = "student";
		System.out.println(exp);
		// 预期结果与实际结果比较
		assertEquals("LoginServletTest",exp, act);
	}
	
	@Test
	public void testLoginServlet3() throws Exception {
		// 创建Servlet的运行环境
		ServletRunner sr = new ServletRunner();
		// 向环境中注册Servlet
		sr.registerServlet("LoginServlet", LoginServlet.class.getName());
		// 创建访问Servlet的客户端
		ServletUnitClient client = sr.newClient();
		// 发送请求,并附带参数
		WebRequest loginRequest = new PostMethodWebRequest("http://localhost:8080/LoginServlet");
		loginRequest.setParameter("account", "1601");
		loginRequest.setParameter("password", "111111");
		loginRequest.setParameter("method", "Login");
		loginRequest.setParameter("type", "3");
		
		InvocationContext invocation = client.newInvocation(loginRequest);
		invocation.getServlet().service(invocation.getRequest(), invocation.getResponse());
		// 获得模拟服务器的信息
		WebResponse response = invocation.getServletResponse();
		// 将得到的结果赋予act实际结果
		String act = response.getText();
		System.out.println(act);
		//预期结果
		String exp = "teacher";
		System.out.println(exp);
		// 预期结果与实际结果比较
		assertEquals("LoginServletTest",exp, act);
	}
	
	@Test
	public void testLoginServlet4() throws Exception {
		System.out.println(4);
		// 创建Servlet的运行环境
		ServletRunner sr = new ServletRunner();
		// 向环境中注册Servlet
		sr.registerServlet("LoginServlet", LoginServlet.class.getName());
		// 创建访问Servlet的客户端
		ServletUnitClient client = sr.newClient();
		// 发送请求,并附带参数
		WebRequest loginRequest = new PostMethodWebRequest("http://localhost:8080/LoginServlet");
		loginRequest.setParameter("account", "1601");
		loginRequest.setParameter("password", "111");
		loginRequest.setParameter("method", "Login");
		loginRequest.setParameter("type", "1");
		
		InvocationContext invocation = client.newInvocation(loginRequest);
		invocation.getServlet().service(invocation.getRequest(), invocation.getResponse());
		// 获得模拟服务器的信息
		WebResponse response = invocation.getServletResponse();
		// 将得到的结果赋予act实际结果
		System.out.println(response);
		System.out.println(response.getTitle());
		String act = response.getText();
		System.out.println(act);
		//预期结果
		String exp = "loginError";
		System.out.println("exp"+exp);
		// 预期结果与实际结果比较
		assertEquals("LoginServletTest",exp, act);
	}
}
