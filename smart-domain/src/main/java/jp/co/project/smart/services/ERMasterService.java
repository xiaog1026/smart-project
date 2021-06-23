package jp.co.project.smart.services;

import java.io.InputStream;

import jp.co.project.smart.ermaster.model.ERMaster;

public interface ERMasterService {

	ERMaster getERMaster(InputStream in);
	
	boolean saveERMaster(ERMaster eRMaster);

}
