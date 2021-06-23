package jp.co.project.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.project.smart.model.User;
import jp.co.project.smart.model.UserDto;


@Mapper
public interface UserMapper {

	@Insert("INSERT INTO user_info ( firstName, lastName, username, password, salary, age)  VALUES ( #{firstName}, #{lastName}, #{username}, #{password}, #{salary}, #{age});")
	@Options(useGeneratedKeys = true)
	Integer save(UserDto user);

	@Select("SELECT * from user_info")
	List<User> findAll();

	@Delete("DELETE from user_info WHERE id = #{id}")
	void delete(int id);

	@Select("SELECT * from user_info WHERE username = #{username}")
	UserDto findOne(String username);

	@Select("SELECT * from user_info WHERE id = #{id}")
	UserDto findById(int id);

	@Update("UPDATE user_info set firstName = #{firstName},lastName = #{lastName},username = #{username},password = #{password},salary = #{salary},age = #{age} WHERE id = #{id}")
	int update(UserDto userDto);
}
