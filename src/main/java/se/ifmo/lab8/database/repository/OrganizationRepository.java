package se.ifmo.lab8.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.lab8.database.model.Address;
import se.ifmo.lab8.database.model.Organization;
import se.ifmo.lab8.database.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findAll();
    List<Organization> findAllByUser(User user);
    void removeAllByUser(User user);
    void removeByIdAndUser(Long id, User user);

    Optional<Organization> findByOfficialAddress(Address address);

}
