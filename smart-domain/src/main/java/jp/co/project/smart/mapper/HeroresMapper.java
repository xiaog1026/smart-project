/**
 * 
 */
package jp.co.project.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.project.smart.model.HeroesDto;

/**
 * @author INNOX-002
 *
 */
@Mapper
public interface HeroresMapper {

	@Insert("INSERT INTO heroes_info (age,name,orderlin)  VALUES (#{age}, #{name}, #{orderlin});")
	@Options(useGeneratedKeys = true)
	int save(HeroesDto user);

	@Select("SELECT * from heroes_info")
	List<HeroesDto> findAll();

	@Delete("DELETE from heroes_info WHERE id = #{id}")
	void delete(int id);

	@Select("SELECT * from heroes_info WHERE name = #{name}")
	HeroesDto findOne(String username);

	@Select("SELECT * from heroes_info WHERE id = #{id}")
	HeroesDto findById(int id);

	@Update("UPDATE heroes_info set name = #{name},age = #{age} WHERE id = #{id}")
	int update(HeroesDto userDto);

}
