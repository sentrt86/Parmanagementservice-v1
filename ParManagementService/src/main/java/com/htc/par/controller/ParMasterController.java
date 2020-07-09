package com.htc.par.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.model.ParMaster;
import com.htc.par.service.ParMasterServiceImpl;

@RestController
@RequestMapping("/par/parmaster")
public class ParMasterController {
	
	@Autowired
	ParMasterServiceImpl parMasterServiceImpl;
	
	
	/*
	 * Request handler to get next par sequence 
	 * 
	 * @ResourceAccessException
	 */
	
	
	@RequestMapping(value="/getNextParSeqId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextParSeqId() throws ResourceAccessException{
		return new ResponseEntity<Integer>(parMasterServiceImpl.getNextParSeqId(),HttpStatus.OK);
	}
	
	
	/*
	 * Request handler to create par information in the par master and par relation table
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/createParMaster",method=RequestMethod.POST)
	public ResponseEntity<String> createParMaster(@RequestBody @Valid ParMaster parmaster) throws ResourceNotCreatedException{
		System.out.println("Par master second controller");
		
		return new  ResponseEntity<String>(parMasterServiceImpl.createParMaster(parmaster),HttpStatus.OK);
	}
	
	
	/*
	 * Request handler to get the par information for particular par num
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/getParMasterByParNum/{parNum}",method=RequestMethod.GET)
	public ResponseEntity<List<ParMaster>> getParMasterByParNum(@PathVariable("parNum") String parNum) throws ResourceNotCreatedException{
		System.out.println("Par no:"+parNum);
		return new  ResponseEntity<List<ParMaster>>(parMasterServiceImpl.getParMasterByParNum(parNum),HttpStatus.OK);
	}
	
	/*
	 * Request handler to update the intent to fill and intent sent date
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/updateIntentToFill",method=RequestMethod.POST)
	public ResponseEntity<String> updateIntentToFill(@RequestBody @Valid ParMaster parmaster) throws ResourceNotCreatedException{
		return new  ResponseEntity<String>(parMasterServiceImpl.updateIntentToFill(parmaster.getParId(),parmaster.getParNumber(),parmaster.getIntentToFill(),parmaster.getIntentSentDate()),HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateEmailRecruiters",method=RequestMethod.POST)
	public ResponseEntity<Boolean> updateEmailRecruiters(@RequestBody @Valid ParMaster parmaster) throws ResourceNotCreatedException{
		System.out.println("update email recruiters");
		System.out.println(parmaster);
		return new  ResponseEntity<Boolean>(parMasterServiceImpl.updateEmailRecruiters(parmaster.getParId(),parmaster.getParNumber(),parmaster.getParComment(),parmaster.getEmailSent()),HttpStatus.OK);
	}

}
