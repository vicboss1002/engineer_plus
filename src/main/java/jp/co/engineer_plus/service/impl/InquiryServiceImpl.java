package jp.co.engineer_plus.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.engineer_plus.entity.EqInquiry;
import jp.co.engineer_plus.form.InquiryForm;
import jp.co.engineer_plus.repositories.EqInquiryRepository;
import jp.co.engineer_plus.service.EqServiceException;
import jp.co.engineer_plus.service.InquiryService;
import jp.co.engineer_plus.utility.JavaBeansUtil;

@Service
public class InquiryServiceImpl implements InquiryService {
	@Autowired
	private EqInquiryRepository repository;
	
	@Override
	@Transactional
	public void execute(InquiryForm form) throws EqServiceException {
		try {
			EqInquiry entity = new EqInquiry();
			JavaBeansUtil.exchange(form, entity);
			repository.save(entity);
		} catch(RuntimeException e) {
			throw new EqServiceException(e);
		}
	}
}
