package nl.angeltr.cannolisrruffino.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.angeltr.cannolisrruffino.dtos.CannoliDto;
import nl.angeltr.cannolisrruffino.dtos.CannoliInputDto;
import nl.angeltr.cannolisrruffino.exceptions.RecordNotFoundException;
import nl.angeltr.cannolisrruffino.models.Cannoli;
import nl.angeltr.cannolisrruffino.models.FileUploadResponse;
import nl.angeltr.cannolisrruffino.repositories.CannoliRepository;
import nl.angeltr.cannolisrruffino.repositories.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sun.beans.introspect.PropertyInfo.Name.description;

@Service
public class CannoliService {

    private final FileUploadRepository fileUploadRepository;

    private final GlutenFreeCannoliService glutenFreeCannoliService

    private final CannoliRepository cannoliRepository;

    private PhotoService photoService;


    @Autowired
    public CannoliService(CannoliRepository cannoliRepository,
                          FileUploadRepository fileUploadRepository) {
        this.cannoliRepository = cannoliRepository;
        this.fileUploadRepository = fileUploadRepository;
    }

    @Override
    public List<Cannoli> getCannoli() {
        return cannoliRepository.findAll();
    }


    @Override
    public Cannoli getCannoli(Long id) {
        Optional<Cannoli> cannoli = cannoliRepository.findById(id);

        if (cannoli.isPresent()) {
            return cannoli.get();
        } else {
            throw new RecordNotFoundException("Cannoli niet gevonden");
        }
    }

    @Override
    public List<Cannoli> findCannoliListByName(String cannoliName) {
        var optionalCannoliList = cannoliRepository.findByCannoliTypeContainingIgnoreCase(cannoliName);

        if (optionalCannoliList.isEmpty()) {
            throw new RecordNotFoundException("geen cannoli gevonden met de naam" + cannoliName);
        }

        return optionalCannoliList;
    }


    @Override
    public Cannoli createCannoli(Cannoli cannoli) {

        cannoli.setId(cannoli.getId());
        cannoli.setCannoliName(cannoli.getCannoliName());
        cannoli.setDescription(cannoli.getDescription());
        cannoli.setIngredients(cannoli.getIngredients());
        cannoli.setGlutenFreeCannoli(cannoli.getGlutenFreeCannoli());
        cannoli.setFlavour(cannoli.getFlavour());


        public static CannoliDto transferToDto (Cannoli cannoli){
            var dto = new CannoliDto();

            dto.setId(cannoli.getId());
            dto.setName(cannoli.getCannoliName());
            dto.setFlavour(cannoli.getFlavour());
            dto.setIngredients(cannoli.getIngredients());
            dto.setWeight(cannoli.getWeight());
            dto.setPrice(cannoli.getPrice());
            dto.setGlutenFree(cannoli.getGlutenFree());
            dto.setLinkToStore(cannoli.getLinkToStore());
            dto.setLinkToReview(cannoli.getLinkToReview());
            dto.setLinkToFranchise(cannoli.getLinkToFranchise());
            dto.setLinkToDeliveryRequest(cannoli.getLinkToDeliveryRequest());
            dto.setImage(cannoli.getImage());
            dto.setPackaging(cannoli.getPackaging());
            dto.setAvailable(cannoli.getAvailable());
            dto.setSold(cannoli.getSold());

            return dto;
        }
        public Cannoli toCannoli (CannoliDto cannoliDto){

            var cannoli = new Cannoli();


            cannoli.setName(.getName());
            cannoli.setFlavour(dto.getFlavour());
            cannoli.setIngredients(dto.getIngredients());
            cannoli.setWeight(dto.getWeight());
            cannoli.setPrice(dto.getPrice());
            cannoli.setGlutenFree(dto.getGlutenFree());

            cannoli.setLinkToReview(dto.getLinkToReview());
            cannoli.setLinkToFranchise(dto.getLinkToFranchise());

            cannoli.setImage(dto.getImage());

            cannoli.setAvailable(dto.getAvailable());
            cannoli.setSold(dto.getSold());

            return cannoli;
        }

        public CannoliDto getCannoli (Long id){
            Optional<Cannoli> cannoli = cannoliRepository.findById(id);
            if (cannoli.isPresent()) {
                CannoliDto cannoli1 = transferToDto(cannoli.get());
                return cannoli1;
            } else {
                throw new RecordNotFoundException("No cannoli found");
            }
        }


        public void assignPhotoToCannoli (String name, Long id){

            Optional<Cannoli> optionalCannoli = cannoliRepository.findById(id);
            Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(name);

            if (optionalCannoli.isPresent() && fileUploadResponse.isPresent()) {
                FileUploadResponse photo = fileUploadResponse.get();
                Cannoli cannoli = optionalCannoli.get();
                cannoli.setImage(photo);
                cannoliRepository.save(cannoli);
            }
        }
    }

}
