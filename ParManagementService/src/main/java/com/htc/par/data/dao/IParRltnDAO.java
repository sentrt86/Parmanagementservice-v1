package com.htc.par.data.dao;

import com.htc.par.model.ParRltn;

public interface IParRltnDAO {
	boolean updateParRltn(ParRltn parRltn, int parId);
	boolean deleteParRltn(int parId);
	ParRltn getParRltn(int ParId);

}
