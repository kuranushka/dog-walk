package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.exceptions.NoSuchOwnerException;
import ru.kuranov.dogwalk.model.entity.main.Owner;
import ru.kuranov.dogwalk.model.repository.main.OwnerRepository;
import ru.kuranov.dogwalk.model.service.interfaces.OwnerService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    @Transactional
    public Owner findByName(String ownerName) {
        Optional<Owner> optionalOwner = ownerRepository.findByName(ownerName);
        return optionalOwner.orElseThrow(() -> new NoSuchOwnerException(ownerName));
    }

    @Override
    @Transactional
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }
}
