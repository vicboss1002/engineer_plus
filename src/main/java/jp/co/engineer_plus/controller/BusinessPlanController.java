package jp.co.engineer_plus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.engineer_plus.entity.EpBusinessPlan;
import jp.co.engineer_plus.form.BusinessPlanForm;
import jp.co.engineer_plus.form.InquiryForm;
import jp.co.engineer_plus.service.BusinesPlanService;
import jp.co.engineer_plus.service.EqServiceException;
import jp.co.engineer_plus.utility.PropertiesUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 事業プラン制御コントローラ
 */
@Controller
public class BusinessPlanController {
	@Autowired
	private BusinesPlanService service;
	
    @ModelAttribute
    public BusinessPlanForm setUpBusinessPlanForm() {
    	return new BusinessPlanForm();
    }
    
	@RequestMapping(value="/business_plan", method=RequestMethod.GET)
	public String getBusinessPlan(@RequestParam(value="page", defaultValue="1") Integer page, Model model) {
		Sort sort = new Sort(Sort.Direction.DESC, "updatedDate");
		PageRequest request = new PageRequest((page < 1? 0: page - 1), PropertiesUtil.getSettingToInt("page_limit", 5), sort);
		Page<EpBusinessPlan> businessPlans = service.createPage(request);
		model.addAttribute("businessPlans", businessPlans);
		model.addAttribute("pageSelectors", createPageSelectors(businessPlans));
		return "business_plan";
	}
	@RequestMapping(value="/business_plan", method=RequestMethod.POST)
	public String postBussinessPlan(@ModelAttribute("businessPlanForm") BusinessPlanForm form, Model model) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			service.execute(form);
			map.put(PropertiesUtil.getMessage("I10000"), true);
		} catch(EqServiceException e) {
			map.put(PropertiesUtil.getMessage("E10000"), true);
		}
		model.addAttribute("resultMap", map.entrySet());
		return this.getBusinessPlan(1, model);
	}
	private List<Integer> createPageSelectors(Page<?> page) {
		List<Integer> list = new ArrayList<>();
		int maxNumber = page.getTotalPages() + 1;
		boolean isPageLimit = maxNumber > 10;
		int firstNumber = 1;
		if (page.getNumber() >= 4 && isPageLimit) {
			firstNumber += page.getNumber() - 3;
		}
		if (isPageLimit) {
			maxNumber = 10;
			maxNumber += firstNumber;
		}
		if (maxNumber > page.getTotalPages() + 1) {
			maxNumber = page.getTotalPages() + 1;
		}
		for (int i = firstNumber; i < maxNumber; i++) {
			list.add(i);
		}
		return list;
	}
}
