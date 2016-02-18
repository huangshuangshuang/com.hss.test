package com.haowu.hss.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Driver;

public class JDBCUtil {
	private String userName;
	private String password;
	private String url;
	private PreparedStatement preparedStatement;
	private Connection connection;
	private ResultSet resultSet;
	/**
	 * 根据数据库连接获取数据库
	 *
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @param url
	 *            数据库连接
	 */
	public JDBCUtil(String userName, String password, String url) {
		this.userName = userName;
		this.password = password;
		this.url = url;
	}

	/**
	 * 用默认的用户名和密码获取数据库连接
	 */
	public JDBCUtil() {
		this.userName = "root";
		this.password = "root";
		this.url = "jdbc:mysql://localhost:3306/mysql_test?useUnicode=true&characterEncoding=UTF-8";
	}

	static {
		Driver.class.getClass();
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, password);
	}

	public List<Map<String, Object>> query(String sql, Object[] objs) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				preparedStatement.setObject(i + 1, objs[i]);
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			while (resultSet.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < columnCount; i++) {
					map.put(resultSetMetaData.getCatalogName(i), resultSet.getObject(i));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	public int batch(String sqls){
		int result=0;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(sqls);
			preparedStatement.addBatch(sqls);
			connection.commit();
			int[] results=preparedStatement.executeBatch();
			for (int i = 0; i < results.length; i++) {
				result+=results[i];
			}
			return result;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			close();
		}
		return -1;
	}

	/**
	 * 不带查询条件的查询方法
	 * 
	 * @param sql
	 *            查询语句
	 * @return 封装的List
	 */
	public List<Map<String, Object>> query(String sql) {
		return query(sql, new Object[] {});
	}

	public int update(String sql, Object[] objs) {
		int result = -1;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				preparedStatement.setObject(i + 1, objs[i]);
			}
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
/**
 * 反射实现属性加载
 * @param sql
 * @param objs
 * @return
 * @throws Exception
 */
	public int update(String sql, Object objs) throws Exception {
		int result = -1;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			Class<?> obj = objs.getClass();
			Field[] fields = obj.getDeclaredFields();
			int count=1;
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				Object object = fields[i].get(objs);
				if (object != null) {
					preparedStatement.setObject(count, object);
					count++;
				}
			}
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally {
			close();
		}
		return result;
	}

	public int update(String sql) {
		return update(sql, new Object[] {});
	}

	public void close() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
