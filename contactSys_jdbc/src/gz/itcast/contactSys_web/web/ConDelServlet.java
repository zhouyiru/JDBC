package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 删除联系人的servlet
 * @author APPle
 *
 */
public class ConDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)接收需要删除的id
		String id = request.getParameter("id");
		
		//2)在xml文件中删除联系人
		ContactService service = new ContactServiceImpl();
		service.deleteContact(id);
		
		//3)跳转到查询联系人页面
		//重定向
		response.sendRedirect(request.getContextPath()+"/ConListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
