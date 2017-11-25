package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ѯ��ϵ�˵�servlet
 * @author APPle
 *
 */
public class ConQueryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)������Ҫ�޸ĵ�id
		String id = request.getParameter("id");
		
		//2)��ѯ��Ӧ����ϵ��
		ContactService service = new ContactServiceImpl();
		Contact contact = service.findById(id);
		
		//3)������ת����jspҳ��
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/editCon.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
