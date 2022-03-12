package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.exceptions.NoSuchCitizenshipException;
import ru.kuranov.dogwalk.model.entity.location.Citizenship;
import ru.kuranov.dogwalk.model.repository.location.CitizenshipRepository;
import ru.kuranov.dogwalk.model.service.interfaces.CitizenshipService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitizenshipServiceImpl implements CitizenshipService {

    private final CitizenshipRepository citizenshipRepository;

    @Override
    public Citizenship findByName(String name) {
        Optional<Citizenship> citizenshipOptional = citizenshipRepository.findByName(name);
        return citizenshipOptional.orElseThrow(() -> new NoSuchCitizenshipException(name));
    }

    @Override
    public List<Citizenship> findAll() {
        return citizenshipRepository.findAll();
    }
}
