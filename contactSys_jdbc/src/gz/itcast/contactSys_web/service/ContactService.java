package gz.itcast.contactSys_web.service;

import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.exception.NameExistException;

import java.util.List;

/**
 * ��ϵ�˵�service�ӿ�
 * @author APPle
 *
 */
public interface ContactService {
	public void addContact(Contact contact)throws NameExistException;
	public void updateContact(Contact contact);  //�����޸ĵ�id
	public void deleteContact(String id);
	public List<Contact> findAll();
	public Contact findById(String id); //����id��ѯ��Ӧ����ϵ��
}
