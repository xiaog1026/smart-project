package jp.co.project.smart.autogen.mapper;

import java.util.List;
import jp.co.project.smart.autogen.model.TableMaster;
import jp.co.project.smart.autogen.model.TableMasterExample;
import org.apache.ibatis.annotations.Param;

public interface TableMasterMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	long countByExample(TableMasterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	int deleteByExample(TableMasterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	int deleteByPrimaryKey(Integer tableId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	int insert(TableMaster record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	int insertSelective(TableMaster record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	List<TableMaster> selectByExample(TableMasterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	TableMaster selectByPrimaryKey(Integer tableId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	int updateByExampleSelective(@Param("record") TableMaster record, @Param("example") TableMasterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	int updateByExample(@Param("record") TableMaster record, @Param("example") TableMasterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	int updateByPrimaryKeySelective(TableMaster record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table table_master
	 * @mbg.generated  Wed Jan 20 13:39:44 JST 2021
	 */
	int updateByPrimaryKey(TableMaster record);
}