package com.htc.par.data.dao;

import com.htc.par.to.EmailRecruitersTO;
import com.htc.par.to.IntentToFill;

public interface IParMiscDAO {
	
	int getparId(String parno);
	IntentToFill getIntentTofillforParId(int parId);
	EmailRecruitersTO getEmailRecruitersforParId(int parId);

}
