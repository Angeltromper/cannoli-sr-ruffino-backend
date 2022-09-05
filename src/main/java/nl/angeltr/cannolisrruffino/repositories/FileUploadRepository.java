package nl.angeltr.cannolisrruffino.repositories;

import nl.angeltr.cannolisrruffino.models.FileUploadResponse;

import java.util.Optional;

public interface FileUploadRepository {
    Optional<FileUploadResponse>findByFIleName(String fileName);

}
