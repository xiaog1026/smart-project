package jp.co.project.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import jp.co.project.smart.model.JyutakuDto;
import jp.co.project.smart.model.UserDto;


@Mapper
public interface JyutakuMapper {

	@Insert("INSERT INTO house_info (url, name, jyutakuno, madori, menseki, shozaikai,shozaiti)  VALUES (#{url}, #{name}, #{jyutakuNo}, #{madori}, #{menseki}, #{shozaikai}, #{shozaiti});")
	@Options(useGeneratedKeys = true)
	Integer save(JyutakuDto jyutakuDto);
	
	@Select("SELECT * from house_info")
	List<JyutakuDto> findAll();
	
	@Delete("DELETE from house_info WHERE id = #{id}")
	void delete(int id);
	
	@Select("SELECT * from house_info WHERE id = #{id}")
	JyutakuDto findById(int id);
}
