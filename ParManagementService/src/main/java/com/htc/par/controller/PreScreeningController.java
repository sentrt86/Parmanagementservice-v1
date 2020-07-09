package com.htc.par.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.model.ParAllocation;
import com.htc.par.service.ParAllocationServiceImpl;
import com.htc.par.to.ParAllocationTO;

@RestController
@RequestMapping("/par/prescreening")
public class PreScreeningController {
	
	@Autowired
	ParAllocationServiceImpl parAllocationServiceImpl;
	
	@RequestMapping(value="/getParallocations/{parNo}",method=RequestMethod.GET)
	public ResponseEntity<List<ParAllocation>> getAllParAllocations(@PathVariable int parNo){
		System.out.println("prescreenign second controller invoked ");
		return new ResponseEntity<List<ParAllocation>>(parAllocationServiceImpl.getAllParAllocations(parNo),HttpStatus.OK);
		
	}

	@RequestMapping(value="/updatePrescreening",method=RequestMethod.POST)
	public ResponseEntity<Boolean> updatePrescreeningDetails(@RequestBody ParAllocationTO parAllocationTO){
		System.out.println("prescreening second controller invoked ");
		System.out.println(parAllocationTO);
		return new ResponseEntity<Boolean>(parAllocationServiceImpl.UpdateParAllocation(parAllocationTO),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getParnumberforparId/{parId}",method=RequestMethod.GET)
	public ResponseEntity<String> getParnumberforparId(@PathVariable int parId){
		System.out.println("prescreening second controller invoked for parnumber ");
		System.out.println(parId);
		return new ResponseEntity<String>(parAllocationServiceImpl.getParnumberforparId(parId),HttpStatus.OK);
		
	}
}
