package com.example.crowdfunding.security.dao;

import com.example.crowdfunding.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "utilisateurs", path = "utilisateurs")
public interface UsersRepository extends JpaRepository<AppUser, Long> {

	@RestResource(path = "/profileUser")
	public AppUser findByUsername(@Param("username") String username);

	//@RestResource(path = "/profile")
	//public List<AppUser> findByUsernameContains(@Param("username") String username);
}
