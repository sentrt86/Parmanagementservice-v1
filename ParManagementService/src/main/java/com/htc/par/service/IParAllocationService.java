package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.model.ParAllocation;
import com.htc.par.to.ParAllocationTO;

@Service
public interface IParAllocationService {
	
	List<ParAllocation> getAllParAllocations(int parNo);
	boolean UpdateParAllocation(ParAllocationTO parAllocationTO);
	String deleteParAllocation(int parAllocationId);
	String getParnumberforparId(int parId);

}
