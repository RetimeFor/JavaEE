package servlet.study;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext中常用的方法
 * @author ywb
 *
 */

@WebServlet("/ServletContextDemo1")//通过注解的方式，不需要再在web.xml文件中配置映射了
public class ServletContextDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("你好啊");
		
		ServletContext sc = getServletContext();
		System.out.println(sc.getInitParameter("name"));//获取web.xml文件中放入的参数
		//sc.getRealPath("");获取webContent内文件路径
		
		Properties properties = new Properties();//创建属性对象
		InputStream in = new FileInputStream("E:\\eclipse\\workspace\\javaweb_study\\src\\servlet\\study\\test.properties");
		//InputStream in = sc.getResourceAsStream("")
		//InputStream in = this.getClass().getClassLoader().getResourceAsStream("");//根据类加载器classLoader来获取资源路径
		//注意，上面三种方式放置的路径可以各不相同
		properties.load(in);//指定载入数据源
		String str = properties.getProperty("alphabet");//获取alphabet的属性值
		System.out.println(str);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
