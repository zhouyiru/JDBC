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
 * �޸���ϵ�˵�servlet
 * @author APPle
 *
 */
public class ConUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1)���ձ�������
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String id = request.getParameter("id");

		//�����ݷ�װ��Contact����
		Contact contact = new Contact();
		contact.setName(name);
		contact.setGender(gender);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setAddress(address);
		contact.setId(id);
		
		//2)�����ݱ��浽xml
		ContactService service = new ContactServiceImpl();
		service.updateContact(contact);
		
		//3)��ת����ѯ��ϵ��ҳ��
		response.sendRedirect(request.getContextPath()+"/ConListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
