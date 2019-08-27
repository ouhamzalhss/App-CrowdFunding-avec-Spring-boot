package com.example.crowdfunding.web;

import com.example.crowdfunding.dao.FichierAssocierRepository;
import com.example.crowdfunding.dao.PlanProjetRepository;
import com.example.crowdfunding.dao.PlanningExecutionRepository;
import com.example.crowdfunding.dao.ProjetRepository;
import com.example.crowdfunding.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


@Controller
public class ProjetController {
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private FichierAssocierRepository fichierAssocierRepository;
	@Autowired
	private PlanningExecutionRepository planningExecutionRepository;
	@Autowired
	private PlanProjetRepository planProjetRepository;
	

	
	@RequestMapping(value="/getProjets",method= RequestMethod.GET)
	public String index(Model model,
						@RequestParam(name="page",defaultValue="0") int p,
						@RequestParam(name="size",defaultValue="5") int s,
						@RequestParam(name="mc",defaultValue="") String mc) {
		Page<Projet> projets= projetRepository.chercher("%"+mc+"%", new PageRequest(p, s));
		model.addAttribute("listProjets",projets.getContent());
		int[] pages=new int[projets.getTotalPages()];
		model.addAttribute("pages",pages );
		model.addAttribute("pageCourante",p );
		model.addAttribute("motCle",mc );
		return "projets";
	}
	@RequestMapping(value="/formProjet")
	public String formProjet(Model model) {
		model.addAttribute("projet",new Projet());
		return "formProjet";
	}
	@RequestMapping(value="/editProjet", method = RequestMethod.GET)
	public String editProjet(Model model,@RequestParam(name = "id",defaultValue = "1") Long id) {
		Projet p=projetRepository.findById(id).get();
		model.addAttribute("fichierAssociers",fichierAssocierRepository.findByProjet(p));
		model.addAttribute("planExecution",planProjetRepository.findByProjet(p));
		model.addAttribute("planExecution",planningExecutionRepository.findByProjet(p));
		model.addAttribute("projet",p);
		return "formProjet";
	}
	@RequestMapping(value="/viewProjet", method = RequestMethod.GET)
	public String viewProjet(Model model,@RequestParam(name = "id",defaultValue = "1") Long id) {
		Projet p=projetRepository.findById(id).get();
		model.addAttribute("fichierAssociers",fichierAssocierRepository.findByProjet(p));
		model.addAttribute("planExecution",planProjetRepository.findByProjet(p));
		model.addAttribute("planExecution",planningExecutionRepository.findByProjet(p));
		model.addAttribute("projet",p);
		return "viewProjet";
	}
	@RequestMapping(value="/saveProjet")
	public String saveEntreprise(Model model, @Valid Projet e, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formProjet";
		}
		projetRepository.save(e);
		return "redirect:/projets";
	}

	@RequestMapping(value = "/getDescription", method = RequestMethod.GET)
	public @ResponseBody	String getDescription() {
		String resp = "qqqqqqqqqqq";
		try {
			resp = "<p>" + projetRepository.findById(1L).get().getDescriptionProjet() + "</p>";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resp = "<p>" + "Request failed, please try again." + "</p>";
		}
		return resp;
	}



	@RequestMapping(
			value = ("/upload"),
			headers = "content-type=multipart/form-data",
			method = RequestMethod.POST)
	public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("dataType") String dataType) {
		System.out.println(file.getOriginalFilename());
		System.out.println(dataType);
		return ResponseEntity.noContent().build();
	}

}
