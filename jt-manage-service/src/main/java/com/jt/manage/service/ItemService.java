package com.jt.manage.service;

import java.util.List;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.pojo.Item;

public interface ItemService {
	public EasyUIResult findItemList(int page, int rows);
	
	//查询分类名称
	public String findItemCatName(Long itemCatId);
}
