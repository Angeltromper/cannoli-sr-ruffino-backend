package nl.angeltr.cannolisrruffino.controllers;

import nl.angeltr.cannolisrruffino.models.Cannoli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CannoliController {

    @CrossOrigin
    @RestController
    @RequestMapping("/cannolis")
    public class CannoliController {

        private final CannoliService cannoliService;

        private final PhotoController photoController;

        @Autowired
        public CannolisController(CannoliService cannoliService, PhotoController controller) {
            this.cannoliService = cannoliService;
            this.controller = controller;


        }

    @GetMapping("/cannolis")
    public ResponseEntity<List<CannoliDto>> getAllCannolis(@RequestParam(value = "brand" , required = false) Optional<String> brand) {

        List<Cannoli> dtos;

        if (brand.isEmpty()) {

            dtos = cannoliService.getAllCannoli();

        } else {

            dtos = cannoliService.getAllCannolisByTaste(brand.get());

        }

        return ResponseEntity.ok().body(dtos);

    }

    @GetMapping("/cannolis/{id}")
    public ResponseEntity<CannoliDto> getCannoli(@PathVariable("id")Long id) {

        CannoliDto cannoli = cannoliService.getCannoliById(id);

            return ResponseEntity.ok().body(cannoli);
    }

    @PostMapping("/cannolis")
    public ResponseEntity<Object> addCannoli(@RequestBody CannoliInputDto cannoliInputDto) {

        CannoliDto dto = cannoliService.addCannoli(cannoliInputDto);

            return ResponseEntity.created(null).body(dto);
    }


    @PostMapping("/cannolis/{id}/{photo}")
    public void assignPhotoToCannoli(@PathVariable("id") Long id,
                                     @RequestParam("image") MultipartFile file) {
        FileUploadResponse image = controller.singleFileUpload(file);
        discService.assignPhotoToCannoli(image.getFileName(), id);
    }

    @PutMapping("/cannolis/{id}")
    public ResponseEntity<Object>updateCannoli(@PathVariable Long id, @RequestBody CannoliInputDto ) {

        CannoliDto dto = cannoliService.updateCannoli(id, newCannoli);

            return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/cannolis/{id}")
    public ResponseEntity<Object> deleteCannoli(@PathVariable Long id) {

        cannoliService.deleteCannoli(id);

            return ResponseEntity.noContent().build();




    }
}
