package servlet.study;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ServletDownLoad")
public class ServletDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");

		String fileName = request.getParameter("fileName");
		fileName = URLEncoder.encode(fileName,"UTF-8");//弹出的下载框中文件名字的编码(谷歌浏览器,火狐浏览器还是会出现乱码,需设置其他格式)
		
		String clientType = request.getHeader("User-Agent");//获取客户端浏览器类型
		if(clientType.contains("Firefox")){
			System.out.println("火狐浏览器打开的");
			
		}
		
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);//弹出下载框
		String path = "E:\\eclipse\\workspace\\javaweb_study\\WebContent\\filedownload\\picture.jpg";
		InputStream in = new FileInputStream(path);
		OutputStream out = response.getOutputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len = in.read(buffer)) != -1){
			out.write(buffer,0,len);
		}
		out.close();
		in.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
