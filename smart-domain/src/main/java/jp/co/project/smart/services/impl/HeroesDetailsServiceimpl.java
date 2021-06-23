package jp.co.project.smart.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.project.smart.mapper.HeroresMapper;
import jp.co.project.smart.model.HeroesDto;
import jp.co.project.smart.services.HeroesDetailsService;

@Service(value = "heroesService")
public class HeroesDetailsServiceimpl implements HeroesDetailsService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 82439981982964014L;
	
	@Autowired
	private HeroresMapper heroresMapper;
	
	public List<HeroesDto> findAll() {
		List<HeroesDto> list = new ArrayList<>();
		heroresMapper.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	public void delete(int id) {
		heroresMapper.delete(id);
	}

	public HeroesDto findOne(String name) {
		return heroresMapper.findOne(name);
	}

	public HeroesDto findById(int id) {
		return heroresMapper.findById(id);

	}

	public HeroesDto update(HeroesDto userDto) {
		HeroesDto user = findById(userDto.getId());
		if (user != null) {
			BeanUtils.copyProperties(userDto, user, "password");
			heroresMapper.save(userDto);
		}
		return userDto;
	}

	public HeroesDto save(HeroesDto user) {
		heroresMapper.save(user);
		return user;
	}
}
