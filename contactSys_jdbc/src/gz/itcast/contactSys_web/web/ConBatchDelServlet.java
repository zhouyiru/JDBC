package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 批量删除的servlet
 * @author APPle
 *
 */
public class ConBatchDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)得到需要删除的联系人
		String[] ids = request.getParameterValues("item");
		
		ContactService service = new ContactServiceImpl();
		//2)批量删除
		for(String id:ids){
			service.deleteContact(id);
		}
		
		//3)跳转列表页面
		response.sendRedirect(request.getContextPath()+"/ConListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
