
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bdqn.rongke.BBSSystem.daoInterface.DaoInterface;
import com.bdqn.rongke.BBSSystem.entity.Page;
import com.bdqn.rongke.BBSSystem.entity.Post;

public class UserTest {

	
	/*@Test
	public void TestMess() throws Exception {
*/
	public static void main(String[] args) throws IOException {
		//ʵ������־����
		 //Logger logger = Logger.getLogger(UserTest.class); 
	
		//��ȡ�����ļ�
		String resource="mybatis-config.xml";
		//��ȡ������
		System.out.println("ddd");
		InputStream is=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory ��������
		//23�����ģʽ������ģʽ������ģʽ
		System.out.println("ddd");
		SqlSessionFactory sif = new SqlSessionFactoryBuilder().build(is);
		
		int count=0;
		//����һ�����ݿ����ӻỰ
		SqlSession ss=null;
		//����һ�����ӻỰ
		ss=sif.openSession();

		/*Page ps = new Page();
		HashMap map =new HashMap();
		map.put("str", "2345");
		map.put("id",1);*/
		int pid=38;
		//ss.getMapper(DaoInterface.class).modifyPwd(map);
		//count=ss.selectOne("com.bdqn.rongke.Mapper.Mapper.getRows");
		System.out.println("ddd");
		Post po= ((DaoInterface) ss.getMapper(DaoInterface.class)).postmess(pid);
		//logger.debug("success"+po);
		ss.close();
	}
	/*ע��:  ��Ԫ����*/
	/*@Test
	public void Postmess() throws IOException {
	public static void main(String[] args) throws IOException {
		
		//ʵ������־����
		 //Logger logger = Logger.getLogger(UserTest.class); 
	
		//��ȡ�����ļ�
		String resource="mybatis-config.xml";
		//��ȡ������
		InputStream is=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory ��������
		//23�����ģʽ������ģʽ������ģʽ
		
		SqlSessionFactory sif = new SqlSessionFactoryBuilder().build(is);
		
		int count=0;
		//����һ�����ݿ����ӻỰ
		SqlSession ss=null;
		//����һ�����ӻỰ
		ss=sif.openSession();

		/*Page ps = new Page();
		HashMap map =new HashMap();
		map.put("str", "2345");
		map.put("id",1);
		int pid=38;
		//ss.getMapper(DaoInterface.class).modifyPwd(map);
		//count=ss.selectOne("com.bdqn.rongke.Mapper.Mapper.getRows");
		Post po= ss.getMapper(DaoInterface.class).postmess(pid);
		//logger.debug("success"+po);
		ss.close();
	}*/


}
