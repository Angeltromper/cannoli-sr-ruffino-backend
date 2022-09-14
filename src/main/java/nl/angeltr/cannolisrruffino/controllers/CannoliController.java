package nl.angeltr.cannolisrruffino.controllers;

import nl.angeltr.cannolisrruffino.dtos.CannoliDto;
import nl.angeltr.cannolisrruffino.dtos.CannoliInputDto;
import nl.angeltr.cannolisrruffino.models.Cannoli;
import nl.angeltr.cannolisrruffino.service.CannoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("cannolis")
public class CannoliController {
    private final CannoliService cannoliService;

    private final PhotoController photoController;

    @Autowired
    public CannoliController(CannoliService cannoliService, PhotoController photoController) {
        this.cannoliService = cannoliService;
        this.photoController = photoController;

    }

    @GetMapping

    public List<CannoliDto> getCannolis(@RequestParam(value = "cannoliName",required = false, defaultValue = "") String cannoliName,
                                        @RequestParam(value = "cannoliType", required = false, defaultValue = "") String cannoliType) {

        var dtos = new ArrayList<CannoliDto>();
        List<Cannoli> cannoliList;

        if (cannoliName == null && cannoliType == null) {

            cannoliList = cannoliService.getCannolis();
        } else if (cannoliName != null && cannoliType == null) {

            cannoliList = cannoliService.findCannoliListByName(cannoliName);

        } else {

            cannoliList = cannoliService.findCannoliListByType(cannoliType);

        }

        var cannolis    = cannoliService.getCannolis();
        for (Cannoli cannoli : cannolis) {
            dtos.add(CannoliDto.fromCannoli(cannoli));
        }
        return dtos;



    @GetMapping("/{id}")
    public ResponseEntity<CannoliDto> getCannoliBy(@PathVariable("id") Long id) {
        try {
            CannoliDto cannoli = cannoliService.getCannoli(id);
            return ResponseEntity.ok().body(cannoli);
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/create")
    public Cannoli addCannoli(@RequestBody CannoliDto dtd) {
       Cannoli newCannoli = cannoliService.createCannoli(dto);
       return newCannoli;
    }

    @PutMapping("/{id}")
    public CannoliDto updateCannoli(@PathVariable Long id,
                                    @RequestBody Cannoli cannoli) {
        cannoliService.updateCannoli(cannoli);

        return CannoliDto.fromCannoli(cannoli);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Cannoli> deleteCannoli(@PathVariable("id") Long id) {
        cannoliService.deleteCannoli(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("product/{id}/picture/{fileName}")
    public void assignImageToCannoli(@PathVariable("id") Long cannoliId,
                                     @PathVariable("fileName") String fileName) {
        cannoliService.assignImageToCannoli(fileName, cannoliId);
    }
}
