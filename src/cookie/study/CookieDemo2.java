package cookie.study;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取上次登录时间
 * @author ywb
 *
 */
@WebServlet("/CookieDemo2")
public class CookieDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if("root".equals(userName) && "123456".equals(password)){
			
			Cookie[] cookies = request.getCookies();
			
				if(cookies != null && cookies.length > 1){//如果不是第一次访问
					for(Cookie cookie : cookies){
						if("lastTime".equals(cookie.getName())){
							long value =Long.parseLong(cookie.getValue());//将其转换成long类型的数据
							response.getWriter().write("欢迎您" + userName + ",  您上一次访问的时间为" + new Date(value));
							cookie.setValue(System.currentTimeMillis() +"");//重新设置登录时间
							response.addCookie(cookie);//修改时间后，必须把修改后的cookie对象再次发给客户端
						}
					}
				}
				else{//如果是第一次访问
					Cookie c = new Cookie("lastTime" , System.currentTimeMillis() +"");//注意System.currentTimeMillis()加上一个空串，转换成字符串类型
					c.setMaxAge(60*60);//一个小时
					response.addCookie(c);
					response.getWriter().write("欢迎您第一次登录");
				}
			
			
		}else{
			response.getWriter().write("用户名或密码错误，请重新输入");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
