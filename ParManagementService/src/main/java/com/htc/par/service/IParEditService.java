package com.htc.par.service;

import org.springframework.stereotype.Service;

import com.htc.par.model.ParMaster;
import com.htc.par.to.ParMasterTO;

@Service
public interface IParEditService {
	
	ParMaster getParDetails(String parno) throws Exception;
	String updatePardetails(ParMasterTO parmasterTo);
	String deleteParDetails(String parno);
	

}
