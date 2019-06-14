package com.lpt.dao.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.dbunit.Assertion;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lpt.dao.impl.StudentDaoImpl;
import com.lpt.dao.inter.StudentDaoInter;

public class StudentDaoTest {
	
	/** 被测试的数据访问类对象*/
	private StudentDaoInter stdDao = new StudentDaoImpl();
	
	/**
	 * 
	 * @throws 测试添加学生dao
	 */
//	@Test
//	public void testInsertObject() throws Exception {
//		//输出方法名
//				System.out.println("testInsertObject");
//				//调用StudentDao的insert方法
//				stdDao.insert((Object)getStudentInsert());
//				
//				
//				//从studentData_exp.xml中获取DataSet作为预期的DataSet
//				IDataSet expectedDataSet = new FlatXmlDataSetBuilder()
//						.build(new FileInputStream(directoryStr + "/"
//								+ this.getClass().getSimpleName()+"_exp_insert.xml"));
//				//从expectedDataSet中获取student表作为预期的table
//				ITable expectedTable = expectedDataSet.getTable("student");
//				//在预期的table上添加排除列规则后得到对应的table
//				ITable expectedTable_ex = DefaultColumnFilter
//						.excludedColumnsTable(expectedTable, new String[]{"Id","classes"});
//				
//				//创建QueryDataSet作为实际的DataSet
//				QueryDataSet actualDataSet = new QueryDataSet(getConnection());
//				//为DataSet添加student表
//				actualDataSet.addTable("student");
//				//从actualDataSet中获取student表作为实际的table
//				ITable actualTable = actualDataSet.getTable("student");
//				//在实际的table上添加排除列规则后得到对应的table
//				ITable actualTable_ex = DefaultColumnFilter
//						.excludedColumnsTable(actualTable, new String[]{"Id","classes"});
//				//为了更明了的比较将实际结果存放到studentData_act.xml文件中
//				FlatXmlDataSet.write(actualDataSet 
//						, new FileOutputStream(new File(directoryStr + "/" 
//								+ this.getClass().getSimpleName() +"_act_insert.xml")));
//				
//				//比较添加排除规则的table是否一致
//				Assertion.assertEquals(expectedTable_ex,actualTable_ex);
//				//比较table是否一致
//				//Assertion.assertEquals(expectedTable,actualTable);
//	}
	
	
}
