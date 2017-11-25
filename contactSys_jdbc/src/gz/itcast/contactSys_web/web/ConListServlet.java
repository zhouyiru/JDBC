package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ѯ��ϵ�˵�servlet
 * @author APPle
 *
 */
public class ConListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)��ȡ������ϵ������
		ContactService service = new ContactServiceImpl();
		List<Contact> conList = service.findAll();
		
		//2)�����ݷ����������
		request.setAttribute("conList", conList);
		
		//3)ת����jspҳ����
		request.getRequestDispatcher("/listCon.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
