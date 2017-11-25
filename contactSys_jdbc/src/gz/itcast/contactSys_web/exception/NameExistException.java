package gz.itcast.contactSys_web.exception;
/**
 * 自定义异常（姓名是否重复）
 * @author APPle
 *
 */
public class NameExistException extends Exception{

	public NameExistException(String msg){
		super(msg);
	}
}
