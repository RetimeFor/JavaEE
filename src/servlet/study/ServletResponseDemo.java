package servlet.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletResponseDemo
 */
@WebServlet("/ServletResponseDemo")
public class ServletResponseDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");//必须通过这两行设置编码格式，否则中文输出乱码
		//response.setHeader("ContentType", "text/html;charset=utf-8");也可用这行代替上行
		
		response.getWriter().write("<h1>你好,世界</h1>");//直接在页面输出(可以在里面放html代码)
		//response.getOutputStream().write("<h2>你好,中国<h2>".getBytes());//使用字节流的方式
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
