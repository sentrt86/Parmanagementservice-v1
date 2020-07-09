package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.ParMasterDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.model.ParMaster;

@Service
public class ParMasterServiceImpl  implements IParMasterService{

	@Autowired
	ParMasterDAOImpl parMasterDaoImpl;
	
	@Override
	public String createParMaster(ParMaster parmaster)  throws ResourceNotCreatedException{
		try {
			System.out.println("par master second service");
			System.out.println(parmaster);
			System.out.println(parmaster.getParNumber());
			List<ParMaster> parMasterList = parMasterDaoImpl.getParMasterByParNum(parmaster.getParNumber());
			System.out.println(parMasterList.isEmpty());
			if(parMasterList.isEmpty())
			{
				if(parMasterDaoImpl.createParMaster(parmaster))
				{
					return String.format(ParConstants.createSuccessfull + "for Par Number : %s",parmaster.getParNumber());
				}
			}
			else
			{
				throw new ResourceDuplicateException(String.format(ParConstants.duplicateFound + "for Par Number : %s",parmaster.getParNumber()));
			}
			
		}catch(DataAccessException e) {
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);
		}
		return String.format(ParConstants.createUnSuccessfull + "for Par Number : %s",parmaster.getParNumber());
	}

	@Override
	public Boolean createParMasterRltn(ParMaster parmaster) throws ResourceNotCreatedException{
		try {
			return parMasterDaoImpl.createParMasterRltn(parmaster);		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}

	@Override
	public int getNextParSeqId() throws ResourceAccessException{
		try {
			return parMasterDaoImpl.getNextParSeqId();		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }
	}

	@Override
	public List<ParMaster> getParMasterByParNum(String parNum) throws ResourceNotFoundException {
		List<ParMaster> parmasterList = new ArrayList<ParMaster> (); 
		try {
			parmasterList = parMasterDaoImpl.getParMasterByParNum(parNum);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for ParMaster Number : %S",parNum));	
		}catch(DataAccessException ex) { 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}

		return parmasterList;
	}

	@Override
	public String updateIntentToFill(int parId,String parNum, Boolean intentToFill, String intentSentDate)
			throws ResourceNotFoundException {
		try {
			boolean updateParmaster = parMasterDaoImpl.updateIntentToFill(parId, intentToFill, intentSentDate);
			if (updateParmaster)
			{
				return String.format(ParConstants.updateSuccessfull + "for Par Master: %s",parNum);
			}
		}catch(DataAccessException ex) { 
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Par Master Number : %S",parNum));
		}
		return null;
	}

	@Override
	public boolean updateEmailRecruiters(int parId, String parNum, String parComment, Boolean emailSent)
			throws ResourceNotFoundException {
		boolean EmailRecruiterUpdated=false;
		try {
			System.out.println("parID:"+parId);
			System.out.println("parNum"+parNum);
			System.out.println("parcomment"+parComment);
			System.out.println("emailSent"+emailSent);
		
			 if(parId != 0)
			 {
				 EmailRecruiterUpdated = parMasterDaoImpl.updateEmailRecruitersbyParId(parId, parComment, emailSent);
			 }
			 else
			 {
				 System.out.println("update email recruiter by parnum");
			 EmailRecruiterUpdated = parMasterDaoImpl.updateEmailRecruitersbyParNum(parNum, parComment, emailSent);
			 }
			 return EmailRecruiterUpdated;
			
		}catch(DataAccessException ex) { 
			throw new ResourceNotFoundException(String.format(ParConstants.dataNotFound + "for Par Master ID : %S",parId));
		}
	}

}
