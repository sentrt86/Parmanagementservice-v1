package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.par.data.dao.IParAllocationDAO;
import com.htc.par.data.mapper.ParAllocationMapper;
import com.htc.par.model.ParAllocation;
import com.htc.par.to.ParAllocationTO;

@Repository
public class ParAllocationDAOImpl implements IParAllocationDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<ParAllocation> getAllParAllocations(int parNo) {
		System.out.println("par allocation DAO"+parNo);
		Object[] parms = new Object[] {parNo};
		int[] parmtype = new int[] {Types.INTEGER};
		return jdbcTemplate.query(ParSqlQueries.getAllParAllocationQuery, parms, parmtype, new ParAllocationMapper());
	}

	@Override
	public boolean updateParAllocation(ParAllocationTO parAllocationTO) {
		Object[] parms = new Object[] {parAllocationTO.getPrescrId(),parAllocationTO.getPreScrdate(),parAllocationTO.getPreScrCommnt(),parAllocationTO.getParAllocId()};
		System.out.println("parAllocation update DAO ----");
		boolean parAllocationUpdated=false;
		int[] parmtype = new int[] {Types.INTEGER,Types.DATE,Types.CHAR,Types.INTEGER};
		int updateCount= jdbcTemplate.update(ParSqlQueries.updateParAllocationQuery, parms, parmtype);
		System.out.println("updateCount"+updateCount);
		if(updateCount>0)
		{
			parAllocationUpdated=true;
		}
		
		return parAllocationUpdated;
	}

	@Override
	public boolean deleteParAllocation(int parAllocationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getParnumberforParId(int parId) {
		Object[] parms = new Object[] {parId};
		int[] parmtype = new int[] {Types.INTEGER};
		return jdbcTemplate.queryForObject(ParSqlQueries.getparNoforParId, parms, parmtype,String.class);
	}

}
