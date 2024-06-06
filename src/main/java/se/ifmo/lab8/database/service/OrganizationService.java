package se.ifmo.lab8.database.service;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import se.ifmo.lab8.database.model.Address;
import se.ifmo.lab8.database.model.Organization;
import se.ifmo.lab8.database.model.User;
import se.ifmo.lab8.database.repository.OrganizationRepository;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class OrganizationService {
    OrganizationRepository organizationRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Organization findById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<Organization> findAllByUser(User user) {
        return organizationRepository.findAllByUser(user);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void removeAllByUser(User user) {
        organizationRepository.removeAllByUser(user);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void removeByIdAndUser(Long id, User user) {
        organizationRepository.removeByIdAndUser(id, user);
    }

    public Optional<Organization> findByOfficialAddress(Address address) {
        return organizationRepository.findByOfficialAddress(address);
    }
}
