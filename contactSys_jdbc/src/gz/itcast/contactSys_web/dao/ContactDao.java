package gz.itcast.contactSys_web.dao;

import gz.itcast.contactSys_web.entity.Contact;

import java.util.List;

/**
 * ��ϵ��dao�ӿ�
 * @author APPle
 *
 */
public interface ContactDao {
	public void addContact(Contact contact);
	public void updateContact(Contact contact);  //�����޸ĵ�id
	public void deleteContact(String id);
	public List<Contact> findAll();
	public Contact findById(String id); //����id��ѯ��Ӧ����ϵ��
	//��������Ƿ��ظ�
	public boolean checkNameExist(String name); 
}
