package se.ifmo.lab8.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.lab8.database.model.User;

import java.util.Optional;

//репозиторий для работы с сущностью пользователя. Поиск по имени пользователя и паролю + проверки существования пользователя по имени
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
