package com.htc.par.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.ParMaster;
import com.htc.par.service.ParEditserviceImpl;
import com.htc.par.to.ParMasterTO;

@RestController
@RequestMapping("/par/paredit")
public class ParEditController {
	
	@Autowired ParEditserviceImpl pareditserviceimpl;
	
	@RequestMapping(value="/getPardetails/{parNo}",method=RequestMethod.GET)
	public ResponseEntity<ParMaster> getParDetails(@PathVariable("parNo") String parNo) throws ResourceNotFoundException{
		System.out.println("Second controller invoked");
		System.out.println("parno"+parNo);
		return new ResponseEntity<ParMaster>(pareditserviceimpl.getParDetails(parNo),HttpStatus.OK);
	}
	
	@RequestMapping(value="/updatePardetails",method=RequestMethod.POST)
	public ResponseEntity<String> updateParDetails(@RequestBody @Valid ParMasterTO parmasterTo) throws ResourceNotFoundException,ResourceNotUpdatedException{
		System.out.println("Second controller invoked");
		System.out.println("parmasterTo:"+parmasterTo);
		return new ResponseEntity<String>(pareditserviceimpl.updatePardetails(parmasterTo),HttpStatus.OK);
	}
	
	@RequestMapping(value="/deletePardetails/{parNo}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteParDetails(@PathVariable("parNo") String parNo) throws ResourceNotFoundException,ResourceNotUpdatedException{
		System.out.println("Second controller invoked delete");
		System.out.println("delete method"+ parNo);
		return new ResponseEntity<String>(pareditserviceimpl.deleteParDetails(parNo),HttpStatus.OK);
	}
	
	

}
