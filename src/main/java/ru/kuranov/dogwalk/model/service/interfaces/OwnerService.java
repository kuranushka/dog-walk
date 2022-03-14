package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.owner.Owner;

@Service
public interface OwnerService {
    Owner findByName(String ownerName);

    void save(Owner owner);

    boolean isThereSuchUsername(String username);
}
