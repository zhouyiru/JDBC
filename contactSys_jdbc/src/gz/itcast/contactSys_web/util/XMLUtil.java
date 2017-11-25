package gz.itcast.contactSys_web.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * ��xml�ļ���ͨ�õĲ���������ȡ����
 * @author APPle
 *
 */
public class XMLUtil {

	/**
	 * ��ȡxml�ļ�������document����
	 */
	public static Document getDocument(){
		try {
			Document doc = new SAXReader().read(new File("e:/contact.xml"));
			return doc;
		} catch (DocumentException e) {
			e.printStackTrace();
			//��ת��Ϊ����ʱ�쳣�׳����ɣ�
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ����docuemnt����д����xml�ļ���
	 */
	public static void write2xml(Document doc){
		try {
			OutputStream out = new FileOutputStream("e:/contact.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(out,format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			//��ת��Ϊ����ʱ�쳣�׳����ɣ�
			throw new RuntimeException(e);
		}
	}
}
