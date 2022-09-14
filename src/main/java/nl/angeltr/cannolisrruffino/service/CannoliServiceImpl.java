package nl.angeltr.cannolisrruffino.service;


import nl.angeltr.cannolisrruffino.dtos.CannoliDto;
import nl.angeltr.cannolisrruffino.exceptions.RecordNotFoundException;
import nl.angeltr.cannolisrruffino.models.Cannoli;
import nl.angeltr.cannolisrruffino.repositories.CannoliRepository;
import nl.angeltr.cannolisrruffino.repositories.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CannoliServiceImpl implements CannoliService {

    private final CannoliRepository cannoliRepository;

    private PhotoService photoService;

    private final FileUploadRepository fileUploadRepository;
    private Cannoli optionalCannoliList;

    @Autowired
    public CannoliServiceImpl(CannoliRepository cannoliRepository,
                              FileUploadRepository fileUploadRepository) {
        this.cannoliRepository = cannoliRepository;
        this.fileUploadRepository = fileUploadRepository;
    }

    @Override
    public List<Cannoli> getCannolis() { return cannoliRepository.findAll(); }

;    @Override
    public Cannoli getCannoli(Long id) {
        Optional<Cannoli> cannoli = cannoliRepository.findById(id);

        if (cannoli.isPresent()) {
            return cannoli.get();
        } else {
            throw new RecordNotFoundException("Cannoli niet gevonden");
        }


        return optionalCannoliList;
    }

    @Override
    public List<Cannoli>findCannoliListByType(String cannoliType) {
        var optionalCannoliList = cannoliRepository.findByCannoliTypeContainingIgnoreCase(cannoliType);

        if (optionalCannoliList.isEmpty()) {
            throw new RecordNotFoundException("geen producten(en) gevonden");
        }

        return optionalCannoliList;
    }

    @Override
    public Cannoli createCannoli(Cannoli cannoli) {



