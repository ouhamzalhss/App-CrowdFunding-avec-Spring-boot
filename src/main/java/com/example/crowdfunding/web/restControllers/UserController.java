package com.example.crowdfunding.web.restControllers;

import com.example.crowdfunding.dao.ContributionRepository;
import com.example.crowdfunding.dao.PersonRepository;
import com.example.crowdfunding.entities.Contribution;
import com.example.crowdfunding.entities.Personne;
import com.example.crowdfunding.entities.Projet;
import com.example.crowdfunding.security.dao.UsersRepository;
import com.example.crowdfunding.security.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class UserController {

     @Autowired
     private PersonRepository personRepository;
    @Autowired
    private ContributionRepository contributionRepository;

    @PostMapping(path = "/uploadPhoto/{username}")
    public void uploadPhoto(MultipartFile file, @PathVariable String username) throws IOException {
        Personne pers = personRepository.findByUsername(username);
        pers.setImageUrl(username + ".jpg");
        Files.write(Paths.get(System.getProperty("user.home") + "/crowdFunding/users/" + pers.getImageUrl()), file.getBytes());
        personRepository.save(pers);
    }

    @GetMapping(path = "/photoUser/{username}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("username") String username) throws IOException {
        Personne pers = personRepository.findByUsername(username);
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/crowdFunding/users/" + pers.getImageUrl()));
    }

  /*  @GetMapping(path = "/getPersoneProjet/{idPersone}/{typePersone}")
    public List<Contribution> getPersonePRojet(@PathVariable("idPersone") Long idPersone,@PathVariable("typePersone") Character typePersone ) throws IOException {
        List<Contribution>  contributions = contributionRepository.findByPersonneAndTypePersonneEquals(idPersone,typePersone);
        return contributions;
    }*/
}
