package jp.co.project.smart.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.project.smart.autogen.mapper.TableMasterMapper;
import jp.co.project.smart.autogen.model.TableMaster;
import jp.co.project.smart.autogen.model.TableMasterExample;
import jp.co.project.smart.autogen.model.TableMasterExample.Criteria;
import jp.co.project.smart.model.QueryParams;
import jp.co.project.smart.services.TablesService;

@Service
public class TablesServiceImpl implements TablesService {

	@Autowired
	private TableMasterMapper tableMasterMapper;

	@Override
	public List<TableMaster> searchAllTables() {

//		return null;
		return this.tableMasterMapper.selectByExample(new TableMasterExample());
	}

	@Override
	public List<TableMaster> searchTablesByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TableMaster> searchTables(QueryParams queryParams) {
		// TODO Auto-generated method stub
		TableMasterExample example = new TableMasterExample();
		Criteria criteria = example.createCriteria();
		if (!queryParams.getKeyWord().equals("")) {
			if (queryParams.getQueryOption().equals("option2")) {
				criteria.andPhysicalNameLike("%" + queryParams.getKeyWord() + "%");
			} else {
				criteria.andPhysicalNameLike(queryParams.getKeyWord() + "%");
			}
		}
		return this.tableMasterMapper.selectByExample(example);
	}

	@Override
	public int registerTable(TableMaster tableMaster) {
		int i = tableMasterMapper.insertSelective(tableMaster);
		if (i != 1) {
			return 0;
		}
		return i;
	}

	@Override
	public TableMaster searchTable(int tableId) {
		return tableMasterMapper.selectByPrimaryKey(tableId);
	}

	@Override
	public int modifyTable(TableMaster tableMaster) {
		return tableMasterMapper.updateByPrimaryKey(tableMaster);
	}

}
