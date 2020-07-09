package com.htc.par.data.dao;

import com.htc.par.model.ParMaster;
import com.htc.par.model.ParRltn;
import com.htc.par.to.EmailRecruitersTO;
import com.htc.par.to.IntentToFill;
import com.htc.par.to.ParMasterTO;

public interface IParEditDAO {
	
	ParMaster getParDetails(String parno);
	boolean updateParDetails(ParMaster parmaster);
	boolean deleteParDetails(String parno);
}
