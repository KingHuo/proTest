package cn.e3mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;

@Controller
public class IndexController {

	@Value("${index.ad1.cid}")
	private long indexAd1Cid;
	@Autowired
	private ContentService contentService;

	@RequestMapping("/index")
	public String showIndex(Model model) {
		//展示页面之前 先获取内容信息
		List<TbContent> ad1List = contentService.getContentList(indexAd1Cid);
		//传递给jsp
		model.addAttribute("ad1List",ad1List);
		//返回逻辑视图
		return "index";
	}

}
