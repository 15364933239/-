package com.lpt.dao.inter;

import java.util.List;

import com.lpt.bean.Clazz;
import com.lpt.bean.Page;

/**
 * 班级数据层接口
 * @author lpt
 *
 */
public interface ClazzDaoInter extends BaseDaoInter {
	
	/**
	 * 获取班级详细信息
	 * @param gradeid 年级ID
	 * @param page 分页参数
	 * @return
	 */
	public List<Clazz> getClazzDetailList(String gradeid, Page page);
	
}
