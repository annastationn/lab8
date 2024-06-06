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

//сервисный класс для управления орг
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
// сохраняет переданную орг в БД
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Organization findById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }
//ищет орг по ее ид
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
//возвращает весь список орг из БД
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<Organization> findAllByUser(User user) {
        return organizationRepository.findAllByUser(user);
    }
//возвращает список орг принадлежащим пользователю
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void removeAllByUser(User user) {
        organizationRepository.removeAllByUser(user);
    }
//удаляет все орг принадлежащие пользователю
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void removeByIdAndUser(Long id, User user) {
        organizationRepository.removeByIdAndUser(id, user);
    }
//удаляет орг по ее ид, если она пренадлежит пользователю
    public Optional<Organization> findByOfficialAddress(Address address) {
        return organizationRepository.findByOfficialAddress(address);
    }
    //ищет орг по ее оф адресу
}
