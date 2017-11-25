package gz.itcast.contactSys_web.dao.impl;

import gz.itcast.contactSys_web.dao.ContactDao;
import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.util.XMLUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.Element;
/**
 * xml版本的dao实现类
 * @author APPle
 *
 */
public class ContactDaoImpl implements ContactDao {

	public void addContact(Contact contact) {
		try {
			//把联系人信息保存到xml文件中去
			/**
			 * <contact id="001">
				<name>张三</name>
				<gender>男</gender>
				<phone>13411112222</phone>
				<email>zs@qq.com</email>
				<address>广州天河</address>
			  </contact>
			 */
			//1)读取原来的xml文件,返回document对象
			Document doc = XMLUtil.getDocument();
			
			//2)修改document对象
			Element rootElem = doc.getRootElement();
			//添加标签
			Element conElem = rootElem.addElement("contact");
			//添加属性
			//编号使用UUID算法生成一个随机且唯一的字符串
			conElem.addAttribute("id", UUID.randomUUID().toString());
			//添加子标签
			conElem.addElement("name").setText(contact.getName());
			conElem.addElement("gender").setText(contact.getGender());
			conElem.addElement("phone").setText(contact.getPhone());
			conElem.addElement("email").setText(contact.getEmail());
			conElem.addElement("address").setText(contact.getAddress());
			
			//3)把修改后的document对象写出到原来的xml文件中（覆盖原来的xml）
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除联系人
	 */
	public void deleteContact(String id) {
		//1)读取原来的xml
		Document doc = XMLUtil.getDocument();
		
		//2)删除contact标签
		//2.1 根据id查询对应的contact标签
		Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
		
		if(conElem!=null){
			//2.2删除
			conElem.detach();
		}
		
		//3)把修改的document写出到xml文件
		XMLUtil.write2xml(doc);
	}

	public List<Contact> findAll() {
		//1）读取xml文件
		Document doc = XMLUtil.getDocument();
		
		//2)获取所有的contact标签
		List<Element> conList = (List<Element>)doc.getRootElement().elements("contact");
		
		List<Contact> list = new ArrayList<Contact>();
		for (Element conElem : conList) {
			//2.1 创建Contact对象
			Contact contact = new Contact();
			//2.2 把contact标签信息封装到COntact对象中
			contact.setId(conElem.attributeValue("id"));
			contact.setName(conElem.elementText("name"));
			contact.setGender(conElem.elementText("gender"));
			contact.setPhone(conElem.elementText("phone"));
			contact.setEmail(conElem.elementText("email"));
			contact.setAddress(conElem.elementText("address"));
			//2.3 把Contact对象放入List
			list.add(contact);
		}
		return list;
	}

	/**
	 * 根据id查询对应的联系人
	 */
	public Contact findById(String id) {
		//1)读取xml文件
		Document doc = XMLUtil.getDocument();
		//2)查询对应的contact标签
		Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
		Contact contact = null;
		if(conElem!=null){
			//创建COntact对象
			contact = new Contact();
			//把contact标签内容封装到Contact对象中
			contact.setId(conElem.attributeValue("id"));
			contact.setName(conElem.elementText("name"));
			contact.setGender(conElem.elementText("gender"));
			contact.setPhone(conElem.elementText("phone"));
			contact.setEmail(conElem.elementText("email"));
			contact.setAddress(conElem.elementText("address"));
		}
		return contact;
	}

	public void updateContact(Contact contact) {
		try {
			//1)读取原理的xml文件
			Document doc = XMLUtil.getDocument();
			//2)修改document对象
			/**
			 * <contact id="001">
				<name>张三</name>
				<gender>男</gender>
				<phone>13411112222</phone>
				<email>zs@qq.com</email>
				<address>广州天河</address>
			  </contact>
			 */
			//2.1 根据id查询对应的contact标签
			Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
			
			//2.2 修改对应的contact标签内容
			conElem.element("name").setText(contact.getName());
			conElem.element("gender").setText(contact.getGender());
			conElem.element("phone").setText(contact.getPhone());
			conElem.element("email").setText(contact.getEmail());
			conElem.element("address").setText(contact.getAddress());
			
			//3)修改的document对象写出xml文件中
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public boolean checkNameExist(String name) {
		//1)获取xml文件
		Document doc = XMLUtil.getDocument();
		
		//2)查询是否某个文本内容的name标签
		Element nameElem = (Element)doc.selectSingleNode("//name[text()='"+name+"']");
		return nameElem!=null?true:false;
	}

	public static void main(String[] args) {
		ContactDao dao = new ContactDaoImpl();
		System.out.println(dao.checkNameExist("张三丰1"));
	}
}
