package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.main.Owner;

@Service
public interface OwnerService {

    Owner findByUsername(String ownerName);

    void save(Owner owner);
}
