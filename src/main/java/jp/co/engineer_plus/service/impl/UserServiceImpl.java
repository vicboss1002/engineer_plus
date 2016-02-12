package jp.co.engineer_plus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.engineer_plus.repositories.EqUserRepository;
import jp.co.engineer_plus.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private EqUserRepository repository;
}
