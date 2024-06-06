package se.ifmo.lab8.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.lab8.database.model.Address;
import se.ifmo.lab8.database.model.Organization;
import se.ifmo.lab8.database.model.User;

import java.util.List;
import java.util.Optional;

//репозиторий для работы с сущностью организации в БД
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findAll();
    //возвращает список обьектов из БД
    List<Organization> findAllByUser(User user);
    //возвращает список орг, которые принадлежат указанному пользователю
    void removeAllByUser(User user);
    //удаляет все орг, которые принадлежат указанному пользователю
    void removeByIdAndUser(Long id, User user);
    //удаляет по ид только если принадлежит пользователю

    Optional<Organization> findByOfficialAddress(Address address);

}
