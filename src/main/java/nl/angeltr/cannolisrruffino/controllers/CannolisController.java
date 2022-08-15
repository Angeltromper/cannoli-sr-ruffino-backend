package nl.angeltr.cannolisrruffino.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/cannolis")
public class CannolisController {

    private final CannoliService cannoliService;
    private final PhotoController photoController;

    @Autowired
    public CannolisController()
}

@GetMapping("/cannolis")
public ResponseEntity<List<CannolisDto>> getAllCannolis(@RequestParam(value = "taste" , required = false) Optional<String> taste) {

    List<CannolisDto> dtos;

    if (taste.isEmpty()) {

        dtos = cannoliService.getAllCannolis();

    } else {

        dtos = cannoliService.getAllCannolisByTaste(taste.get());

    }

    return ResponseEntity.ok().body(dtos);

}

@GetMapping("/cannolis/{id}")
public ResponseEntity<CannoliDto> getCannoli(@PathVariable("id")Long id) {

    CannoliDto cannoli = cannoliService.getCannoliById(id);

    return ResponseEntity.ok().body();
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


@DeleteMapping("/cannolis/{id}")
public ResponseEntity<Object> deleteCannoli(@PathVariable Long id) {

    cannoliService.deleteCannoli(id);

    return ResponseEntity.noContent().build();
}

@PutMapping("/cannolis/{id}")
public ResponseEntity<Object>updateCannoli(@PathVariable Long id, @RequestBody CannoliInputDto ) {

    CannoliDto dto = cannoliService.updateCannoli(id, newCannoli);

    return ResponseEntity.ok().body(dto);
}

@PutMapping("/cannolis/{id}/glutenfreecannolicontroller")
public void assignGlutenFreeCannoliControllerToCannoli(@PathVariable("id") Long id, @RequestBody IdInputDto input) {
    cannoliService.assignGlutenFreeCannoliToCannoli(id, input.id);
}

