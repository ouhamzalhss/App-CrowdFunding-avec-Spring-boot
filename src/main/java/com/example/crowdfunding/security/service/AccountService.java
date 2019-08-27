package com.example.crowdfunding.security.service;

import com.example.crowdfunding.security.entities.AppRole;
import com.example.crowdfunding.security.entities.AppUser;


public interface AccountService {

	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username, String roleName);
    public AppUser findUserByUsername(String username);
	
}
