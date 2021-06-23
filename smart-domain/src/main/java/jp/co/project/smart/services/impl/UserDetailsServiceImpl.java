package jp.co.project.smart.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jp.co.project.smart.mapper.UserMapper;
import jp.co.project.smart.model.User;
import jp.co.project.smart.model.UserDto;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = userMapper.findOne(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userMapper.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	public void delete(int id) {
		userMapper.delete(id);
	}

	public UserDto findOne(String username) {
		return userMapper.findOne(username);
	}

	public UserDto findById(int id) {
		return userMapper.findById(id);

	}

	public UserDto update(UserDto userDto) {
		UserDto user = findById(userDto.getId());
		if (user != null) {
			BeanUtils.copyProperties(userDto, user, "password");
			userMapper.save(userDto);
		}
		return userDto;
	}

	public UserDto save(UserDto user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));

		userMapper.save(user);
		return user;
	}
}
