package jp.co.engineer_plus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.engineer_plus.entity.EpUser;
import jp.co.engineer_plus.form.LoginForm;
import jp.co.engineer_plus.repositories.EqUserRepository;
import jp.co.engineer_plus.service.EqService;
import jp.co.engineer_plus.service.EqServiceException;
import jp.co.engineer_plus.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private EqUserRepository repository;
	
	@Override
	public void execute(LoginForm form) throws EqServiceException {
		try {
			EpUser entity = repository.findByUserId(form.getUserId());
			boolean result = entity.getPassword().equals(form.getPassword())? true: false;
			if (!result) {
				throw new EqServiceException("invalid user id or password");
			}
		} catch(RuntimeException e) {
			throw new EqServiceException(e);
		}
	}

}
