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
 * xml�汾��daoʵ����
 * @author APPle
 *
 */
public class ContactDaoImpl implements ContactDao {

	public void addContact(Contact contact) {
		try {
			//����ϵ����Ϣ���浽xml�ļ���ȥ
			/**
			 * <contact id="001">
				<name>����</name>
				<gender>��</gender>
				<phone>13411112222</phone>
				<email>zs@qq.com</email>
				<address>�������</address>
			  </contact>
			 */
			//1)��ȡԭ����xml�ļ�,����document����
			Document doc = XMLUtil.getDocument();
			
			//2)�޸�document����
			Element rootElem = doc.getRootElement();
			//��ӱ�ǩ
			Element conElem = rootElem.addElement("contact");
			//�������
			//���ʹ��UUID�㷨����һ�������Ψһ���ַ���
			conElem.addAttribute("id", UUID.randomUUID().toString());
			//����ӱ�ǩ
			conElem.addElement("name").setText(contact.getName());
			conElem.addElement("gender").setText(contact.getGender());
			conElem.addElement("phone").setText(contact.getPhone());
			conElem.addElement("email").setText(contact.getEmail());
			conElem.addElement("address").setText(contact.getAddress());
			
			//3)���޸ĺ��document����д����ԭ����xml�ļ��У�����ԭ����xml��
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * ɾ����ϵ��
	 */
	public void deleteContact(String id) {
		//1)��ȡԭ����xml
		Document doc = XMLUtil.getDocument();
		
		//2)ɾ��contact��ǩ
		//2.1 ����id��ѯ��Ӧ��contact��ǩ
		Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
		
		if(conElem!=null){
			//2.2ɾ��
			conElem.detach();
		}
		
		//3)���޸ĵ�documentд����xml�ļ�
		XMLUtil.write2xml(doc);
	}

	public List<Contact> findAll() {
		//1����ȡxml�ļ�
		Document doc = XMLUtil.getDocument();
		
		//2)��ȡ���е�contact��ǩ
		List<Element> conList = (List<Element>)doc.getRootElement().elements("contact");
		
		List<Contact> list = new ArrayList<Contact>();
		for (Element conElem : conList) {
			//2.1 ����Contact����
			Contact contact = new Contact();
			//2.2 ��contact��ǩ��Ϣ��װ��COntact������
			contact.setId(conElem.attributeValue("id"));
			contact.setName(conElem.elementText("name"));
			contact.setGender(conElem.elementText("gender"));
			contact.setPhone(conElem.elementText("phone"));
			contact.setEmail(conElem.elementText("email"));
			contact.setAddress(conElem.elementText("address"));
			//2.3 ��Contact�������List
			list.add(contact);
		}
		return list;
	}

	/**
	 * ����id��ѯ��Ӧ����ϵ��
	 */
	public Contact findById(String id) {
		//1)��ȡxml�ļ�
		Document doc = XMLUtil.getDocument();
		//2)��ѯ��Ӧ��contact��ǩ
		Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
		Contact contact = null;
		if(conElem!=null){
			//����COntact����
			contact = new Contact();
			//��contact��ǩ���ݷ�װ��Contact������
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
			//1)��ȡԭ���xml�ļ�
			Document doc = XMLUtil.getDocument();
			//2)�޸�document����
			/**
			 * <contact id="001">
				<name>����</name>
				<gender>��</gender>
				<phone>13411112222</phone>
				<email>zs@qq.com</email>
				<address>�������</address>
			  </contact>
			 */
			//2.1 ����id��ѯ��Ӧ��contact��ǩ
			Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
			
			//2.2 �޸Ķ�Ӧ��contact��ǩ����
			conElem.element("name").setText(contact.getName());
			conElem.element("gender").setText(contact.getGender());
			conElem.element("phone").setText(contact.getPhone());
			conElem.element("email").setText(contact.getEmail());
			conElem.element("address").setText(contact.getAddress());
			
			//3)�޸ĵ�document����д��xml�ļ���
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public boolean checkNameExist(String name) {
		//1)��ȡxml�ļ�
		Document doc = XMLUtil.getDocument();
		
		//2)��ѯ�Ƿ�ĳ���ı����ݵ�name��ǩ
		Element nameElem = (Element)doc.selectSingleNode("//name[text()='"+name+"']");
		return nameElem!=null?true:false;
	}

	public static void main(String[] args) {
		ContactDao dao = new ContactDaoImpl();
		System.out.println(dao.checkNameExist("������1"));
	}
}
