package com.example.crowdfunding.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EntrepreneurController {

/*    @Autowired
    private EnrepreneurRepository enrepreneurRepository;


    @RequestMapping(value="/entrepreneurs",method= RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(name="page",defaultValue="0") int p,
                        @RequestParam(name="size",defaultValue="5") int s,
                        @RequestParam(name="mc",defaultValue="") String mc) {
        Page<Enrepreneur> entrepreneurs= enrepreneurRepository.chercher("%"+mc+"%", new PageRequest(p, s));
        model.addAttribute("listEntrepreneurs",entrepreneurs.getContent());
        int[] pages=new int[entrepreneurs.getTotalPages()];
        model.addAttribute("pages",pages );
        model.addAttribute("pageCourante",p );
        model.addAttribute("motCle",mc );
        return "entrepreneurs";
    }*/



}
