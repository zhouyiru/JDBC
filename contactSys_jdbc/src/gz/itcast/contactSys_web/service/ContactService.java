package gz.itcast.contactSys_web.service;

import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.exception.NameExistException;

import java.util.List;

/**
 * 联系人的service接口
 * @author APPle
 *
 */
public interface ContactService {
	public void addContact(Contact contact)throws NameExistException;
	public void updateContact(Contact contact);  //包含修改的id
	public void deleteContact(String id);
	public List<Contact> findAll();
	public Contact findById(String id); //根据id查询对应的联系人
}
