package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ɾ����ϵ�˵�servlet
 * @author APPle
 *
 */
public class ConDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)������Ҫɾ����id
		String id = request.getParameter("id");
		
		//2)��xml�ļ���ɾ����ϵ��
		ContactService service = new ContactServiceImpl();
		service.deleteContact(id);
		
		//3)��ת����ѯ��ϵ��ҳ��
		//�ض���
		response.sendRedirect(request.getContextPath()+"/ConListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
