package jp.co.engineer_plus.controller;

import java.util.HashMap;
import java.util.Map;

import jp.co.engineer_plus.form.InquiryForm;
import jp.co.engineer_plus.service.EqServiceException;
import jp.co.engineer_plus.service.InquiryService;








import jp.co.engineer_plus.utility.PropertiesUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * お問い合わせページ制御コントローラ
 */
@Controller
public class InquiryController {
	@Autowired
	private InquiryService service;
    @ModelAttribute
    public InquiryForm setUpInquiryForm() {
    	return new InquiryForm();
    }
	

	
	@RequestMapping(value="/inquiry", method=RequestMethod.GET)
	public String getInquiry(Model model) {
		model.addAttribute("user_name");
		return "inquiry";
	}
	@RequestMapping(value="/inquiry", method=RequestMethod.POST)
	public String postInquiry(@ModelAttribute("inquiryForm") InquiryForm form, Model model) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			service.execute(form);
			map.put(PropertiesUtil.getMessage("I20000"), true);
		} catch(EqServiceException e) {
			e.printStackTrace();
			map.put(PropertiesUtil.getMessage("W20000"), false);
		}
		model.addAttribute("resultMap", map.entrySet());
		return "inquiry";
	}
}
