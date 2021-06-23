package jp.co.project.smart.controller;

import jp.co.project.smart.mapper.UserMapper;
import jp.co.project.smart.model.ApiResponse;
import jp.co.project.smart.model.User;
import jp.co.project.smart.model.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userService;

    @PostMapping
    public ApiResponse<Integer> saveUser(@RequestBody UserDto user){
    	//return null;
       return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @GetMapping
    public ApiResponse<List<User>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<UserDto> getOne(@PathVariable int id){
    	UserDto uto = userService.findById(id);
    	
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",uto);
        
        
    }

    @PostMapping("/{id}")
    public ApiResponse<Integer> update(@RequestBody UserDto userDto) {
    	
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
