package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.TreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCatService;


@Controller
public class ContentCatController {

	@Autowired
	private ContentCatService contentCatService;
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<TreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0") long parentId){
		List<TreeNode> list = contentCatService.getContentCatList(parentId);
		return list;
	}
	
	@RequestMapping("/content/category/create")
	@ResponseBody
	public E3Result addContentCateory(long parentId,String name){
		E3Result e3Result = contentCatService.addContentCategory(parentId, name);
		return e3Result;
	}
	
	@RequestMapping("/content/category/update")
	@ResponseBody
	public E3Result updateContentCateory(long id,String name){
		E3Result e3Result = contentCatService.updateContentCategory(id, name);
		return e3Result;
	}
	
	@RequestMapping("/content/category/delete")
	@ResponseBody
	public E3Result deleteContentCateory(long id){
		E3Result e3Result = contentCatService.deleteContentCategory(id);
		return e3Result;
	}
	
}
