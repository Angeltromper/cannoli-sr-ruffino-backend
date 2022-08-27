package nl.angeltr.cannolisrruffino.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/sell")
public class SellController {

    @Autowired
    private SellService sellService;

    @GetMapping("/all")
    public GetAllSellResponse getAllSellResponse() { return sellService.getAllSells();}
}
