package cookie.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * cookie的使用
 * @author ywb
 *
 */
@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("key-----", "value-----");//创建一个cookie
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		cookie.setMaxAge(5);//设置cookie有效时间,经过5s后再刷新页面发现控制台没有再打印cookie信息(注意要放在添加添加cookie之前)
		response.addCookie(cookie);//给响应添加一个cookie(服务端发一个cookie到客户端)
		
		//获取请求头的全部信息
		/*Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = (String) headerNames.nextElement();
			String value = request.getHeader(name);
			System.out.println(name+"==="+value);
		}*/
		response.getWriter().write("hello");
		
		
		System.out.println("");
		Cookie[] cookies = request.getCookies();
		for(Cookie c:cookies){
			String cookieName = c.getName();
			String cookieValue = c.getValue();
			System.out.println(cookieName + "=================" + cookieValue);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
