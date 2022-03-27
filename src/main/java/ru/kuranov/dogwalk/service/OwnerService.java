package ru.kuranov.dogwalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.exceptions.NoSuchOwnerException;
import ru.kuranov.dogwalk.model.entity.main.Owner;
import ru.kuranov.dogwalk.repository.main.OwnerRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;


    @Transactional
    public Owner findByUsername(String ownerName) {
        Optional<Owner> optionalOwner = ownerRepository.findByUsername(ownerName);
        return optionalOwner.orElseThrow(() -> new NoSuchOwnerException(ownerName));
    }


    @Transactional
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }
}
