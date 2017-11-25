package gz.itcast.contactSys_web.service.impl;

import gz.itcast.contactSys_web.dao.ContactDao;
import gz.itcast.contactSys_web.dao.impl.ContactDaoMySQLImpl;
import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.exception.NameExistException;
import gz.itcast.contactSys_web.service.ContactService;

import java.util.List;
/**
 * ��ϵ�˵�serviceʵ����
 * @author APPle
 *
 */
public class ContactServiceImpl implements ContactService {
	//����dao����
	//ContactDao conDao = new ContactDaoImpl();
	ContactDao conDao = new ContactDaoMySQLImpl();

	/**
	 * ������ϵ��
	 * @throws NameExistException 
	 */
	public void addContact(Contact contact) throws NameExistException {
		//���ҵ���߼��� �����������ظ���ʱ����ʾ�û��������
		//����û����Ƿ���ڵ�
		if(conDao.checkNameExist(contact.getName())){
			//�ظ��ˣ���ô�죿  �׳��Զ����쳣
			throw new NameExistException("�����ظ������ظ�����");
		}
		conDao.addContact(contact);
	}

	public void deleteContact(String id) {
		conDao.deleteContact(id);
	}

	/**
	 * ��ѯ������ϵ��
	 */
	public List<Contact> findAll() {
		//�����ҵ���߼�����ҵ���߼�д������
		List<Contact> list = conDao.findAll();
		return list;
	}

	public Contact findById(String id) {
		return conDao.findById(id);
	}

	public void updateContact(Contact contact) {
		//�������Ժ󲹳�ҵ���߼�
		conDao.updateContact(contact);
	}

}
