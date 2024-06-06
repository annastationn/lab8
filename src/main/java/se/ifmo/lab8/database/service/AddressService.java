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

//сервисный класс отвечает за логику работы со сторонними компонентами
@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
//финальные поля нельзя менять после инициализации
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AddressService {
    AddressRepository addressRepository;

    //методы выполняются в транзакциях для обеспечения целостности данных
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Address save(Address address) {
        return addressRepository.save(address);
    }
//ссылка репозиторий адреса, который используется для взаимодействия с БД по сущности адреса
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Optional<Address> findByZipCode(String zipCode) {
        return addressRepository.findByZipCode(zipCode);
    }
}
