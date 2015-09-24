package tk.cedoo.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class DBManager {
	static final private Logger log = Logger.getLogger(DBManager.class.getClass());
	static final private String RESOURCE = "tk/cedoo/db/mybatis-config.xml";
	private static SqlSessionFactory sqlSessionFactory = null;
	static{
		log.info("DBManager初始化");
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(RESOURCE);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			log.fatal("数据库连接初始化出错!无法正常启动");
		}finally{
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		log.info("DBManager初始化 完成！");
	}
	/**
	 * 得到SqlSessionFactory
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
