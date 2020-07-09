package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.ParMaster;

public interface IParMasterDAO {
	
	Boolean createParMaster(ParMaster parmaster);
	Boolean createParMasterRltn(ParMaster parmaster);
	List<ParMaster>  getParMasterByParNum(String parNum);
	Boolean updateIntentToFill(int parId,Boolean intentToFill,String intentSentDate);
	Boolean updateEmailRecruitersbyParId(int parId,String parComment, Boolean Emailsent);
	Boolean updateEmailRecruitersbyParNum(String parNum,String parComment, Boolean Emailsent);
	int getNextParSeqId();
	

}
