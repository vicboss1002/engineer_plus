package jp.co.engineer_plus.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jp.co.engineer_plus.entity.EpBusinessPlan;
import jp.co.engineer_plus.form.BusinessPlanForm;
import jp.co.engineer_plus.repositories.EqBusinessPlanRepository;
import jp.co.engineer_plus.service.BusinesPlanService;
import jp.co.engineer_plus.service.EqServiceException;

@Service
public class BusinesPlanServiceImpl implements BusinesPlanService {
	@Autowired
	private EqBusinessPlanRepository repository;
	
	@Override
	@Transactional
	public void execute(BusinessPlanForm form) throws EqServiceException {
		try {
			EpBusinessPlan entity = new EpBusinessPlan();
			entity.setName(form.getName());
			entity.setTitle(form.getTitle());
			entity.setContent(form.getContent());
			entity.setCreatedDate(new Date());
			repository.save(entity);
		} catch(RuntimeException e) {
			throw new EqServiceException(e);
		}
	}
	@Override
	public Page<EpBusinessPlan> createPage(PageRequest request) {
		return repository.findAll(request);
	}
}
