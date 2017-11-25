package gz.itcast.contactSys_web.dao;

import gz.itcast.contactSys_web.entity.Contact;

import java.util.List;

/**
 * 联系的dao接口
 * @author APPle
 *
 */
public interface ContactDao {
	public void addContact(Contact contact);
	public void updateContact(Contact contact);  //包含修改的id
	public void deleteContact(String id);
	public List<Contact> findAll();
	public Contact findById(String id); //根据id查询对应的联系人
	//检查姓名是否重复
	public boolean checkNameExist(String name); 
}
