package jp.co.project.smart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.project.smart.mapper.HeroresMapper;
import jp.co.project.smart.model.ApiResponse;
import jp.co.project.smart.model.HeroesDto;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/heroes")
public class HeroesController {

	@Autowired
	private HeroresMapper heroesService;

	@PostMapping
	public ApiResponse<HeroesDto> saveUser(@RequestBody HeroesDto user) {
//        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",heroesService.save(user));
		return null;
	}

	@GetMapping
	public ApiResponse<List<HeroesDto>> listUser() {
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", heroesService.findAll());
	}

	@GetMapping("/{id}")
	public ApiResponse<HeroesDto> getOne(@PathVariable int id) {
		HeroesDto uto = heroesService.findById(id);
		return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.", uto);
	}

	@PostMapping("/{id}")
	public ApiResponse<HeroesDto> update(@RequestBody HeroesDto heroesDto) {
		return null;
//        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",heroesService.update(heroesDto));
	}

	@DeleteMapping("/{id}")
	public ApiResponse<Void> delete(@PathVariable int id) {
		heroesService.delete(id);
		return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
	}

}
