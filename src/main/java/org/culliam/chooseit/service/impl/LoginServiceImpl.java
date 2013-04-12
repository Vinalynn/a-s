package org.culliam.chooseit.service.impl;

import org.apache.log4j.Logger;
import org.culliam.chooseit.service.interfaces.LoginService;

public class LoginServiceImpl implements LoginService {
	Logger log = Logger.getLogger(LoginServiceImpl.class);

	@Override
	public void saveLoginInfo(String info) {
		if (log.isDebugEnabled()) {
			log.debug("µÇÂ½SessionÐÅÏ¢--->" + info);
		}
	}
}
