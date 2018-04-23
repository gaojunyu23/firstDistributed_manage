package com.jt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemMapper itemMapper;
	

	@Override
	public EasyUIResult findItemList(int page, int rows) {
		// 1页   20条数据     SELECT * FROM tb_item LIMIT 0,20
		// 2页   20条数据     SELECT * FROM tb_item LIMIT 20,20
		// 3页   20条数据     SELECT * FROM tb_item LIMIT 40,20
		// n页   20条数据     SELECT * FROM tb_item LIMIT (n-1)*20,20
		
		//查询商品列表
		int start = (page-1)*rows;
		List<Item> itemList = itemMapper.findItemList(start,rows);
		
		//查询商品总数
		int total = itemMapper.findItemCount();
		
		EasyUIResult result = new EasyUIResult();
		result.setTotal(total);
		result.setRows(itemList);
		
		return result;
	}


	@Override
	public String findItemCatName(Long itemCatId) {
		
		return itemMapper.findItemCatName(itemCatId);
	}

}
