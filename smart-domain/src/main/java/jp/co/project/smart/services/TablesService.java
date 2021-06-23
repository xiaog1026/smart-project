package jp.co.project.smart.services;

import java.util.List;

import jp.co.project.smart.autogen.model.TableMaster;
import jp.co.project.smart.model.QueryParams;

public interface TablesService {

	List<TableMaster> searchAllTables();

	List<TableMaster> searchTablesByCondition(String condition);

	List<TableMaster> searchTables(QueryParams queryParams);

	int registerTable(TableMaster tableMaster);

	TableMaster searchTable(int tableId);

	int modifyTable(TableMaster tableMaster);

}
