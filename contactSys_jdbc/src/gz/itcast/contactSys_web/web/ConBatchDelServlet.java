package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����ɾ����servlet
 * @author APPle
 *
 */
public class ConBatchDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)�õ���Ҫɾ������ϵ��
		String[] ids = request.getParameterValues("item");
		
		ContactService service = new ContactServiceImpl();
		//2)����ɾ��
		for(String id:ids){
			service.deleteContact(id);
		}
		
		//3)��ת�б�ҳ��
		response.sendRedirect(request.getContextPath()+"/ConListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
