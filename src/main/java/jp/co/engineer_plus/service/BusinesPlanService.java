package jp.co.engineer_plus.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import jp.co.engineer_plus.entity.EpBusinessPlan;
import jp.co.engineer_plus.form.BusinessPlanForm;

/**
 * 
 * ビジネスプランへのインターフェース
 *
 */
public interface BusinesPlanService extends EqService<BusinessPlanForm, EpBusinessPlan> {
	Page<EpBusinessPlan> findPage(PageRequest request);
}
