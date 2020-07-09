package com.htc.par.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.ParEditDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.ParMaster;
import com.htc.par.model.ParRltn;
import com.htc.par.to.EmailRecruitersTO;
import com.htc.par.to.IntentToFill;
import com.htc.par.to.ParMasterTO;

@Service
public class ParEditserviceImpl implements IParEditService{
	
	@Autowired ParEditDAOImpl pareditDAOimpl;

	@Override
	public ParMaster getParDetails(String parno) throws ResourceNotFoundException {
		ParMaster parmaster = null;
		try {
			System.out.println("Second Service ");
			
			parmaster = pareditDAOimpl.getParDetails(parno);
		}catch(EmptyResultDataAccessException ex) {
			System.out.println("data not found for the parno");
			return null;
		}
		catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); 
		}
		return parmaster;
	}

	@Override
	public String updatePardetails(ParMasterTO parmasterto)throws ResourceNotFoundException, ResourceNotUpdatedException  {
		String data=null;
		int parId=0;
		boolean parRltnUpdated,parMasterUpdated=false;
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			ParMaster parmaster = new ParMaster();
			parmaster.setArea(parmasterto.getArea());
			parmaster.setParNumber(parmasterto.getParNumber());
			parmaster.setParRole(parmasterto.getParRole());
			parmaster.setSkill(parmasterto.getSkill());
			parmaster.setLocation(parmasterto.getLocation());
			parmaster.setParDescriptionText(parmasterto.getParDescriptionText());
			parmaster.setExternalStaff(parmasterto.getExternalStaff());
			parmaster.setParReceivedDate(parmasterto.getParReceivedDate());
			parmaster.setParStatus(parmasterto.getParStatus());
			
			parId=pareditDAOimpl.getparId(parmasterto.getParNumber());
			System.out.println("parId"+parId);
			ParRltn parRltn = new ParRltn(parmasterto.getParRole().getRoleId(),parmasterto.getArea().getAreaId(),parmasterto.getSkill().getSkillId(),parmasterto.getExternalStaff().getExtStaffId(),parmasterto.getLocation().getLocationId());
			System.out.println(parRltn);
			parRltnUpdated = pareditDAOimpl.updateParRltn(parRltn, parId);
			System.out.println("parRltnUpdated:"+parRltnUpdated);
			if(parRltnUpdated)
			{
				parmaster.setParId(parId);
				IntentToFill intenTofill= pareditDAOimpl.getIntentTofillforParId(parId);
				System.out.println("intenTofill:"+intenTofill);

				parmaster.setIntentToFill(intenTofill.getIntentToFillind());
				if(intenTofill.getIntentSentDate()!=null)
				{
				parmaster.setIntentSentDate(dateFormat.format(intenTofill.getIntentSentDate()));
				}
				
				EmailRecruitersTO emailRecruitersTo = new EmailRecruitersTO();
				System.out.println("email recruiters");
				System.out.println("parID"+parId);
				emailRecruitersTo = pareditDAOimpl.getEmailRecruitersforParId(parId);
				parmaster.setEmailSent(emailRecruitersTo.getEmailSent());
				System.out.println("after email recruiting ");
				parmaster.setParComment(emailRecruitersTo.getParComment());
				
				System.out.println(emailRecruitersTo);
				System.out.println(parmaster);
				
				parMasterUpdated = pareditDAOimpl.updateParDetails(parmaster);
				System.out.println("parMasterUpdated:"+parMasterUpdated);
				if(parMasterUpdated)
				{
					data = String.format(ParConstants.updateSuccessfull+"for Par Master Number : %S",parmasterto.getParNumber());
				}
				else
				{
					data = String.format(ParConstants.updateUnSuccessfull+"for Par Master Number : %S",parmasterto.getParNumber());
				}
			}
			else {
				data =String.format(ParConstants.updateUnSuccessfull+ "for Par Relation ID : %S",parId);				
			}
			return data;
			
			
		}
		catch(DataAccessException ex) { 
			throw new ResourceNotFoundException(String.format(ParConstants.updateUnSuccessfull + "for Par Master Number : %S",parmasterto.getParNumber()));
		}
	
	}

	@Override
	public String deleteParDetails(String parno) throws ResourceNotFoundException,ResourceNotDeletedException {
		String data=null;
		int parId=0;
		boolean parRltnDeleted,parMasterDeleted=false;
		try
		{

			parId=pareditDAOimpl.getparId(parno);
			System.out.println("parId delete service 2nd"+parId);
			parRltnDeleted = pareditDAOimpl.deleteParRltn(parId);
			if(parRltnDeleted)
			{
				parMasterDeleted = pareditDAOimpl.deleteParDetails(parno);
				if(parMasterDeleted)
				{
					data= String.format(ParConstants.deleteSuccessfull +"for Par Number: %S", parno);
				}
				else
				{
					data=String.format(ParConstants.deleteUnSuccessfull+"for Par Number: %S", parno);
				}
			}
			else
			{
				data=String.format(ParConstants.deleteUnSuccessfull+"for Par ID: %S", parId);
			}
		}
		catch(DataAccessException ex)
		{
			throw new ResourceNotFoundException(String.format(ParConstants.deleteUnSuccessfull + "for Par Master Number : %S",parno));
		}
		return data;
	}

}
