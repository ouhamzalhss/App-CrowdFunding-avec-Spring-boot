package com.example.crowdfunding.security.web;

import com.example.crowdfunding.security.entities.AppUser;
import com.example.crowdfunding.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm) {
		if(!userForm.getPassword().equals(userForm.getConfirme())) 
			throw new RuntimeException("You must confirm the password");
		if(accountService.findUserByUsername(userForm.getUsername())!=null) 
           throw new RuntimeException("This user already exist");
		AppUser appUser= new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		appUser.setFirstName(userForm.getFirstName());
		appUser.setLastName(userForm.getLastName());
		appUser.setEmail(userForm.getEmail());

	    accountService.saveUser(appUser);
		accountService.addRoleToUser(userForm.getUsername(), "USER");
		return appUser;
	}
}
