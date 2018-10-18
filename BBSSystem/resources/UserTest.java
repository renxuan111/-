
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
		//实例化日志对象
		 //Logger logger = Logger.getLogger(UserTest.class); 
	
		//读取配置文件
		String resource="mybatis-config.xml";
		//获取输入流
		System.out.println("ddd");
		InputStream is=Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory 工厂对象
		//23种设计模式，单例模式，工厂模式
		System.out.println("ddd");
		SqlSessionFactory sif = new SqlSessionFactoryBuilder().build(is);
		
		int count=0;
		//声明一个数据库连接会话
		SqlSession ss=null;
		//开启一个连接会话
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
	/*注解:  单元测试*/
	/*@Test
	public void Postmess() throws IOException {
	public static void main(String[] args) throws IOException {
		
		//实例化日志对象
		 //Logger logger = Logger.getLogger(UserTest.class); 
	
		//读取配置文件
		String resource="mybatis-config.xml";
		//获取输入流
		InputStream is=Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory 工厂对象
		//23种设计模式，单例模式，工厂模式
		
		SqlSessionFactory sif = new SqlSessionFactoryBuilder().build(is);
		
		int count=0;
		//声明一个数据库连接会话
		SqlSession ss=null;
		//开启一个连接会话
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
