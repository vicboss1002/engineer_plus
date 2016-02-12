package jp.co.engineer_plus.service;

import jp.co.engineer_plus.entity.EqEntity;
import jp.co.engineer_plus.form.EqForm;

public interface EqService<F extends EqForm, E extends EqEntity> {
	void execute(F form) throws EqServiceException;
}
