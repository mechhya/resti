package rest.services.config;

import java.io.Reader;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;
@Component
public class ParentDao {
	private static  SqlSession sqlSession = null;
	private static final String RESOURCE = "SqlMapConfig.xml";
	
	private  void getConnections () {
		try {
			Reader rd = Resources.getResourceAsReader(RESOURCE);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
			sqlSession = sqlSessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public <T> T selectOne(String statement) {
		try {
			this.getConnections();
			return sqlSession.selectOne(statement);
		} finally {
			sqlSession.close();
		}
	}

	public <T> T selectOne(String statement, Object parameter) {
		try {
			this.getConnections();
			return sqlSession.selectOne(statement, parameter);
		} finally {
			sqlSession.close();
		}
	}

	public <E> List<E> selectList(String statement) {
		try {
			this.getConnections();
			return  sqlSession.selectList(statement);
		}finally {
			sqlSession.close();
		}
			
	}

	public <E> List<E> selectList(String statement, Object parameter) {
		try {
			this.getConnections();
			return  sqlSession.selectList(statement,parameter);
		}finally {
			sqlSession.close();
		}
	}

	public  <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
		try {
			this.getConnections();
			return sqlSession.selectList(statement, parameter, rowBounds);
		} finally {
			sqlSession.close();
		}
	}

	public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		try {
			this.getConnections();
			return sqlSession.selectMap(statement,mapKey);
		}finally {
			sqlSession.close();
		}
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
		try {
			this.getConnections();
			return sqlSession.selectMap(statement,parameter,mapKey);
		}finally {
			sqlSession.close();
		}
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
		try {
			this.getConnections();
			return sqlSession.selectMap(statement, parameter, mapKey, rowBounds);
		} finally {
			sqlSession.close();
		}
	}

	public <T> Cursor<T> selectCursor(String statement) {
		try {
			this.getConnections();
			return sqlSession.selectCursor(statement);
		} finally {
			sqlSession.close();
		}
		
	}

	public <T> Cursor<T> selectCursor(String statement, Object parameter) {
		try {
			this.getConnections();
			return sqlSession.selectCursor(statement, parameter);
		} finally {
			sqlSession.close();
		}
	}

	public <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds) {
		try {
			this.getConnections();
			return sqlSession.selectCursor(statement, parameter, rowBounds);
		} finally {
			sqlSession.close();
		}
	}

	public void select(String statement, Object parameter, ResultHandler handler) {
		try {
			getConnections();
			sqlSession.select(statement, parameter, handler);
		} finally {
			sqlSession.close();
		}
		
	}

	public void select(String statement, ResultHandler handler) {
		try {
			this.getConnections();
			sqlSession.select(statement, handler);
		} finally {
			sqlSession.close();
		}
		
	}

	public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
		try {
			this.getConnections();
			sqlSession.select(statement, parameter, rowBounds, handler);
		} finally {
			sqlSession.close();
		}
		
	}

	public int insert(String statement) {
		try {
			this.getConnections();
			return sqlSession.insert(statement);
		} finally {
			sqlSession.close();
		}
	}

	public int insert(String statement, Object parameter) {
		try {
			this.getConnections();
			return sqlSession.insert(statement, parameter);
		} finally {
			sqlSession.close();
		}
	}

	public  int update(String statement) {
		try {
			this.getConnections();
			return sqlSession.update(statement);
		} finally {
			sqlSession.close();
		}
	}

	public int update(String statement, Object parameter) {
		try {
			this.getConnections();
			return sqlSession.update(statement, parameter);
		} finally {
			sqlSession.close();
		}
	}

	public int delete(String statement) {
		try {
			this.getConnections();
			return sqlSession.delete(statement);
		} finally {
			sqlSession.close();
		}
	}

	public int delete(String statement, Object parameter) {
		try {
			this.getConnections();
			return sqlSession.delete(statement, parameter);
		} finally {
			sqlSession.close();
		}
	}

	public static void commit() {
		sqlSession.commit();
		
	}

	public static void commit(boolean force) {
		sqlSession.commit(force);
		
	}

	public static void rollback() {
		sqlSession.rollback();
		
	}

	public static void rollback(boolean force) {
		sqlSession.rollback(force);
		
	}

	public static List<BatchResult> flushStatements() {
		return sqlSession.flushStatements();
	}

	public static void close() {
		sqlSession.close();
		
	}

	public static void clearCache() {
		sqlSession.clearCache();
		
	}

	public static Configuration getConfiguration() {
		return sqlSession.getConfiguration();
	}

	public static <T> T getMapper(Class<T> type) {
		return sqlSession.getMapper(type);
	}

	public static Connection getConnection() {
		return sqlSession.getConnection();
	}

}
