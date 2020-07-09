package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.ParAllocationDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Area;
import com.htc.par.model.ParAllocation;
import com.htc.par.to.ParAllocationTO;

@Service
public class ParAllocationServiceImpl implements IParAllocationService {
	
	@Autowired
	ParAllocationDAOImpl parAllocationDAOImpl;

	@Override
	public List<ParAllocation> getAllParAllocations(int parNo) {
		List<ParAllocation> parAllocations=new ArrayList<ParAllocation>();		
		try {
			System.out.println("par allocation service invoked"+parNo);
			parAllocations = parAllocationDAOImpl.getAllParAllocations(parNo);	
			System.out.println(parAllocations);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return parAllocations;
	}

	@Override
	public boolean UpdateParAllocation(ParAllocationTO parAllocationTO) {
		try { 
			System.out.println("second parallocation service ");
			System.out.println(parAllocationTO);
			boolean parAllocationUpdated = parAllocationDAOImpl.updateParAllocation(parAllocationTO); 
			return parAllocationUpdated;
			
		}catch(DataAccessException ex) { 
			throw new ResourceNotUpdatedException(String.format(ParConstants.updateUnSuccessfull + "for parAllocationId : %s",parAllocationTO.getParAllocId())); 
		}
	}

	@Override
	public String deleteParAllocation(int parAllocationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParnumberforparId(int parId) {
		try {
			System.out.println("second service get par number");
			return parAllocationDAOImpl.getParnumberforParId(parId);
		}
		catch(DataAccessException ex) {
			throw new ResourceNotUpdatedException(String.format(ParConstants.dataNotFound + "for parId : %s",parId));
		}
	}

}
