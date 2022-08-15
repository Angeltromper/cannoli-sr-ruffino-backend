package nl.angeltr.cannolisrruffino.controllers;


import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;

@RestController
@CrossOrigin
public class PhotoController {

    private final PhotoService service;

    public PhotoController(PhotoService service) { this.service = service; }

    @PostMapping("/upload")
    FileUploadResponse singleFileUpload(@RequestParam("image") MultipartFile file){

        String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/")
        Sting contentType = file.getContentType();
        String fileName = service.storeFile(file,url);

        return new FileUploadResponse(fileName, contentType, url );

    @GetMapping("/download/{fileName}")
    ResponseEntity<Resource> downLoadSingleFile(@PathVariable String fileName, HttpServletRequest request){

        Resource resource = service.downLoadFile(fileName);
        String mimeType;
        try
            mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            mimeType = PageAttributes.MediaType.Application_octet_stream_value;
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType)).header(HttpHeaders.CONTENT_DISPOSITION) "inline;fileName=" + resource.getFilename()).body(resource);
    }
}








