package se.ifmo.lab8.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.lab8.database.model.Address;

import java.util.Optional;

//репозиторий для работы с сущностью адреса в БД
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByZipCode(String zipCode);
}
