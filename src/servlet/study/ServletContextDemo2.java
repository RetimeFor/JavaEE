package servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");//获取客户端内容
		String password = request.getParameter("password");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");//必须通过这两行设置编码格式，否则中文输出乱码
		
		PrintWriter pw = response.getWriter();//通过response可以将内容输出给客户端
		if("root".equals(userName) && "123456".equals(password)){
			pw.write("登录成功");//输出内容在客户端显示，而不是在控制台打印
		}
		
		else if("admin".equals(userName) && "123456".equals(password)){
			//response.setStatus(302);//302是重新定位的状态码
			//response.setHeader("Location", "study-servlet/success.jsp");
			//response.setHeader("refresh","2;study-servlet/success.jsp");//经过2秒后,跳转到指定页面
			response.sendRedirect("study-servlet/success.jsp");//直接从定向到指定页面
			
			Object obj = getServletContext().getAttribute("count");//获取之前页面的访问次数的值
			int totalCount = 0;
			if(obj != null){
				totalCount = (int)obj;
			}
			getServletContext().setAttribute("count", ++totalCount);//现在页面访问次数值+1
			
		}
		else{
			//response.sendRedirect("study-servlet/login.jsp");//直接重定向
			
			pw.write("用户名或密码错误,请3s后重新输入");
			response.setHeader("refresh","3;study-servlet/login.jsp"); //先在客户端输出,等待3秒后,跳转到指定页面
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
