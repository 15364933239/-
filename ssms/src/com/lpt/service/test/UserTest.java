package com.lpt.service.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

import com.lpt.bean.Teacher;
import com.lpt.bean.User;
import com.lpt.service.TeacherService;
public class UserTest extends DBTestCase {

	private TeacherService teacherService = new TeacherService();
	
	/** 获得当前源文件（.java）所在的目录 */
	private String directoryStr = URLDecoder.decode(System.getProperty("user.dir")+"\\src\\"
			+ this.getClass().getPackage().getName().replace(".", "\\")+"\\xml");
	
	/** 备份当前数据库相关表数据的文件*/
	File backupFile = new File(directoryStr+"/teacherData_back.xml");
	
	/** 类构造方法，通过设置系统环境特性配置JdbcDatabaseTester	 
	 * <dl>
	 * 		<dt>JdbcDatabaseTester</dt>
	 * 		<dd>使用Jdbc驱动管理器获得连接的DatabaseTester</dd>
	 * </dl>
	 */
	public UserTest() {
		super();
		System.setProperty(PropertiesBasedJdbcDatabaseTester
				.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/"
					+ "ssms2?useUnicode=true&characterEncoding=UTF-8");
		System.setProperty(PropertiesBasedJdbcDatabaseTester
				.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester
				.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester
				.DBUNIT_PASSWORD, "root");
	}
	
	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>将当前数据库中测试相关的表先保存到备份文件中。
	 *			可以在执行测试之前调用执行（如编写main方法调用）。</dd>
	 * </dl>
	 * @throws Exception
	 */
	public void backup() throws Exception {
		System.out.println("backup");
		IDatabaseConnection connection = this.getConnection();
		QueryDataSet backupDataSet = new QueryDataSet(connection);
		backupDataSet.addTable("user");
		FlatXmlDataSet.write(backupDataSet, new FileOutputStream(backupFile));
		if (connection != null)
			connection.close();
	}
	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>将备份文件中保存的相关表还原回当前数据库中。
	 *			可以在测试完成之后调用执行（如编写main方法调用）。</dd>
	 * </dl>
	 * @throws SQLException
	 */
	public void restore() throws SQLException {
		System.out.println("restore");
		IDatabaseConnection connection = null;
		try {
			connection = this.getConnection();
			IDataSet dataSet = new FlatXmlDataSetBuilder().build(backupFile);
			//用当前DataSet对数据库进行CLEAN_INSERT操作
			//，包括删除所有数据并插入DataSet中的数据
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
	}
	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>在每个测试初始化时，返回DatabaseOperation。</dd>
	 * </dl>
	 * @return DatabaseOperation.REFRESH，用当前DataSet对数据库进行刷新。
	 * 			插入数据库中没有的行，更新已有的行，数据库中有而DataSet中没有不改变。
	 * @throws Exception
	 * @see org.dbunit.DatabaseTestCase#getSetUpOperation()
	 */
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		System.out.println("getSetUpOperation");
		return DatabaseOperation.REFRESH;
	}
	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>在每个测试结束时，返回DatabaseOperation。</dd>
	 * </dl>
	 * @return DatabaseOperation.NONE，不进行任何操作。
	 * @throws Exception
	 * @see org.dbunit.DatabaseTestCase#getTearDownOperation()
	 */
	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		System.out.println("getTearDownOperation");
		return DatabaseOperation.NONE;
	}
	
	/**
	 * 
	 */
	@Override
	protected IDataSet getDataSet() throws Exception {
		System.out.println("getDataSet");
		System.out.println(directoryStr + "/"+ this.getClass().getSimpleName() +"_pre.xml");
		IDataSet preDataSet = new FlatXmlDataSetBuilder().build(
				new FileInputStream(directoryStr + "/"+ this.getClass().getSimpleName() +"_pre.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(this.getConnection(), preDataSet);
		return preDataSet;
	}
	
	/**
	 * 添加老师测试
	 * @throws Exception
	 */
	public void testInsertObject() throws Exception {
		//输出方法名
		System.out.println("testInsertObject");
//		teacherService.addTeacher(getUser());
		//从studentData_exp.xml中获取DataSet作为预期的DataSet
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder()
				.build(new FileInputStream(directoryStr + "/"
						+ this.getClass().getSimpleName() +"_exp_insert.xml"));
		
		//从expectedDataSet中获取student表作为预期的table
		ITable expectedTable = expectedDataSet.getTable("teacher");
		
		//在预期的table上添加排除列规则后得到对应的table
		ITable expectedTable_ex = DefaultColumnFilter
				.excludedColumnsTable(expectedTable, new String[]{"id"});
		
		//创建QueryDataSet作为实际的DataSet
		QueryDataSet actualDataSet = new QueryDataSet(this.getConnection());
		
		//为DataSet添加student表
		actualDataSet.addTable("user");
		
		//从actualDataSet中获取student表作为实际的table
		ITable actualTable = actualDataSet.getTable("user");
		
		//在实际的table上添加排除列规则后得到对应的table
		ITable actualTable_ex = DefaultColumnFilter
				.excludedColumnsTable(actualTable, new String[]{"id"});
		
		//为了更明了的比较将实际结果存放到studentData_act.xml文件中
		FlatXmlDataSet.write(actualDataSet 
				, new FileOutputStream(new File(directoryStr + "/"
						+ this.getClass().getSimpleName() +"_act_insert.xml"))
				);
		//比较添加排除规则的table是否一致
		Assertion.assertEquals(expectedTable_ex,actualTable_ex);	
	}
	
	
	/**
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>获得老师对象，插入时使用。</dd>
	 * </dl>
	 * @return 所创建的老师对象
	 */
	public User getUser() {
		User user = new User();
		Teacher teacher = new Teacher();
		teacher.setId(19);
		teacher.setName("李沛橦");
		teacher.setNumber("1617");
		teacher.setSex("男");
		teacher.setPhone("15364932329");
		teacher.setQq("724627509");
		return user;
	}

}


