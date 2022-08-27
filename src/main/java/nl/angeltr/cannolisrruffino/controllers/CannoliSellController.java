package nl.angeltr.cannolisrruffino.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productsell")
public class CannoliSellController {


    @Autowired
    private ProductSellService productSellService;

    @PostMapping("/saveproductsell")
    public SaveProductSellResponse saveProductSell(@Valid @RequestBody SaveProductSellRequest saveProductSellRequest) {
        return productSellService.saveProductSell(saveProductSellRequest);
    }
}












}
