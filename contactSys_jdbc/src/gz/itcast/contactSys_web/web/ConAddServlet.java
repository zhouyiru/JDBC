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
 * 添加联系人的servlet
 * @author APPle
 *
 */
public class ConAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决post提交数据的中文乱码
		request.setCharacterEncoding("utf-8");
		
		//1)接收表单的数据
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		//把数据封装到Contact对象
		Contact contact = new Contact();
		contact.setName(name);
		contact.setGender(gender);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setAddress(address);
		
		//2)把数据保存到xml中
		ContactService service = new ContactServiceImpl();
		try {
			service.addContact(contact);
		} catch (NameExistException e) { //姓名重复了，才会出现这个异常
			//e.printStackTrace();
			//处理这个自定义异常
			request.setAttribute("msg", e.getMessage() );
			//转到addCon.jsp
			request.getRequestDispatcher("/addCon.jsp").forward(request, response);
			return;
		}
		
		//3)跳转到查询联系人页面
		//重定向
		response.sendRedirect(request.getContextPath()+"/ConListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
