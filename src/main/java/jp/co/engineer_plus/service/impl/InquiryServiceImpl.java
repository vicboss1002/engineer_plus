package jp.co.engineer_plus.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.engineer_plus.entity.EqInquiry;
import jp.co.engineer_plus.form.InquiryForm;
import jp.co.engineer_plus.repositories.EqInquiryRepository;
import jp.co.engineer_plus.service.InquiryService;

@Service
public class InquiryServiceImpl implements InquiryService {
	@Autowired
	private EqInquiryRepository repository;
	
	@Override
	@Transactional
	public boolean execute(InquiryForm form) {
		try {
			EqInquiry entity = new EqInquiry();
			entity.setName(form.getName());
			entity.setMailAddress(form.getMailAddress());
			entity.setTitle(form.getTitle());
			entity.setContent(form.getContent());
			repository.save(entity);
			return true;
		} catch(RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
}
