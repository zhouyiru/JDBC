package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.exception.NameExistException;
import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �����ϵ�˵�servlet
 * @author APPle
 *
 */
public class ConAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���post�ύ���ݵ���������
		request.setCharacterEncoding("utf-8");
		
		//1)���ձ�������
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		//�����ݷ�װ��Contact����
		Contact contact = new Contact();
		contact.setName(name);
		contact.setGender(gender);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setAddress(address);
		
		//2)�����ݱ��浽xml��
		ContactService service = new ContactServiceImpl();
		try {
			service.addContact(contact);
		} catch (NameExistException e) { //�����ظ��ˣ��Ż��������쳣
			//e.printStackTrace();
			//��������Զ����쳣
			request.setAttribute("msg", e.getMessage() );
			//ת��addCon.jsp
			request.getRequestDispatcher("/addCon.jsp").forward(request, response);
			return;
		}
		
		//3)��ת����ѯ��ϵ��ҳ��
		//�ض���
		response.sendRedirect(request.getContextPath()+"/ConListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
