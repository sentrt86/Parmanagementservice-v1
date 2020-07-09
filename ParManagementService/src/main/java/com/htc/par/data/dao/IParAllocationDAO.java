package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.ParAllocation;
import com.htc.par.to.ParAllocationTO;

public interface IParAllocationDAO {
	
	List<ParAllocation> getAllParAllocations(int parId);
	boolean updateParAllocation(ParAllocationTO parAllocationTO);
	boolean deleteParAllocation(int parAllocationId);
	String getParnumberforParId(int parId);
	

}
