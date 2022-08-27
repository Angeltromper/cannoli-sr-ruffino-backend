package nl.angeltr.cannolisrruffino.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/glutenfreecannoli")
public class GlutenFreeCannoliController {

    private GlutenFreeCannoliController glutenFreeCannoliService;

    @Autowired
    public GlutenFreeCannoliController (GlutenFreeCannoliService glutenFreeCannoliService) {
       this.glutenFreeCannoliService = glutenFreeCannoliService;
    }

    @PostMapping("/{glutenfreeId}/{cannoliId}")
    public void addGlutenFreeCannoli(@PathVariable("glutenfreeId") Long glutenfreeId, @PathVariable("cannoliId") Long cannoliId) {
       glutenFreeCannoliService.addGlutenFreeCannoli(glutenfreeId, cannoliId);
    }


}
