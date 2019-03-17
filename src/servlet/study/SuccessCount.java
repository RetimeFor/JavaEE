package servlet.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SuccessCount")
public class SuccessCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = (int)getServletContext().getAttribute("count");//因为getServletContext作用范围是整个项目，所以它可以取其他类中的值
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");//必须通过这两行设置编码格式，否则中文输出乱码
		response.getWriter().write("该页面访问的次数为:"+count+" 次");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
