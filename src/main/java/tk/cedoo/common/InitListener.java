package tk.cedoo.common;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import tk.cedoo.db.DBManager;

public class InitListener implements ServletContextListener {
	static private final Logger log = Logger.getLogger(InitListener.class.getClass());

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("容器初始化listener");
		try {
			Class.forName("tk.cedoo.db.DBManager");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		SqlSession session = DBManager.getSqlSessionFactory().openSession();
		
		List<Integer> roots = session.selectList("tk.cedoo.common.selectRootNodeID");
		
		/**
		 * 查询根节点ID
		 */
		if(roots!=null && roots.size()>=1){
			arg0.getServletContext().setAttribute("rootNodeID", roots.get(0));
			if(roots.size()>1){
				log.error("根节点数据异常,存在多个根节点。");
			}
		}else{
			log.error("根节点数据初始化失败，未发现根节点");
		}

		/**
		 * 查询根类型ID
		 */
		List<Integer> rootsTypeID = session.selectList("tk.cedoo.common.selectClazzNodeTypeID");
		if(rootsTypeID!=null && rootsTypeID.size()>=1){
			arg0.getServletContext().setAttribute("clazzNodeTypeID", rootsTypeID.get(0));
			if(rootsTypeID.size()>1){
				log.warn("clazz节点类型异常,存在多个根节点类型。");
			}
		}else{
			log.error("clazz类型初始化失败，未发现clazz类型");
		}

		/**
		 * 查询根类型ID
		 */
		List<Integer> leafNodeTypeID = session.selectList("tk.cedoo.common.selectLeafNodeTypeID");
		if(leafNodeTypeID!=null && leafNodeTypeID.size()>=1){
			arg0.getServletContext().setAttribute("leafNodeTypeID", leafNodeTypeID.get(0));
			if(leafNodeTypeID.size()>1){
				log.error("clazz节点类型异常,存在多个根节点类型。");
			}
		}else{
			log.error("clazz类型初始化失败，未发现clazz类型");
		}	
		/**
		 * 查询父子关系 节点类型ID
		 */
		List<Integer> parentAndChildTypeID = session.selectList("tk.cedoo.common.selectParentAndChildTypeID");
		if(parentAndChildTypeID!=null && parentAndChildTypeID.size()>=1){
			arg0.getServletContext().setAttribute("parentAndChildTypeID", parentAndChildTypeID.get(0));
			if(parentAndChildTypeID.size()>1){
				log.error("父子关系 节点类型异常,存在多个父子关系 节点类型。");
			}
		}else{
			log.error("父子关系 节点类型初始化失败，未发现父子关系 节点类型");
		}
		session.close();
		log.info("初始化结束");
		
		log.info("rootNodeID = " + arg0.getServletContext().getAttribute("rootNodeID"));
		log.info("clazzNodeTypeID = " + arg0.getServletContext().getAttribute("clazzNodeTypeID"));
		log.info("parentAndChildTypeID = " + arg0.getServletContext().getAttribute("parentAndChildTypeID"));
	}

}
