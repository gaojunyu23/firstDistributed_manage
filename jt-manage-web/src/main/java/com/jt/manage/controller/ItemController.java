package com.jt.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.vo.EasyUIResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	
	/***
	 * http://localhost:8091/item/query?page=1&rows=20
	 * 
	 * {"title":2000,"rows":[{},{},{}]} easyUI分页格式要求
	 * 所以采用面向对象的方式进行展现 配置@ResponseBody
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody //将集合或对象转化为JSON串  不经过视图解析器
	public EasyUIResult findItemList(int page,int rows){
		
	/*	List<Item> itemList = itemService.findItemList();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(itemList);*/
		
		return  itemService.findItemList(page,rows);
	}
	
	
	//根据商品分类id查询分类名称
	/*@RequestMapping("/cat/queryItemName")
	public void findItemCatName(Long itemCatId,HttpServletResponse response) throws IOException{
		String itemCatName = itemService.findItemCatName(itemCatId);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(itemCatName);
	}*/
	
	@RequestMapping(value="/cat/queryItemName",
			produces="text/html;charset=utf-8")
	@ResponseBody
	public String findItemCatName(Long itemCatId) throws IOException{
		
		return itemService.findItemCatName(itemCatId);
		
	}
	
	
	
	
	
}
