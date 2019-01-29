package com.yjf.esupplier.web.controller.backstage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

/**
 * 后台主框架 2015-7-20
 * @author wuzj
 * @email yuanying@yiji.com
 */
@Controller
@RequestMapping("admin")
public class BackstageMainFrameController extends BaseAutowiredController {
	
	@RequestMapping("mainFrame.htm")
	public String index(String module, Model model) {
		model.addAttribute("module", module);
		return "/backstage/mainFrame.vm";
	}
}
