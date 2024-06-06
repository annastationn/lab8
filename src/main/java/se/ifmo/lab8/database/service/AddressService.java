package se.ifmo.lab8.database.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import se.ifmo.lab8.database.model.Address;
import se.ifmo.lab8.database.repository.AddressRepository;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AddressService {
    AddressRepository addressRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Optional<Address> findByZipCode(String zipCode) {
        return addressRepository.findByZipCode(zipCode);
    }
}
