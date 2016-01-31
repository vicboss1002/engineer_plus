package jp.co.engineer_plus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 事業プラン制御コントローラ
 */
@Controller
public class BusinessPlanController {
	@RequestMapping("/business_plan")
	public String businessPlan() {
		return "business_plan";
	}
}
