package se.ifmo.lab8.database.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import se.ifmo.lab8.database.model.User;
import se.ifmo.lab8.database.repository.UserRepository;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    //регистрирует нового пользователя
    public User register(String username, String password) {
        return userRepository.save(User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                //хеширует пароль с помощью енкодера
                .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
//проверка существования пользователя
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
//поиск пользователя по его имени
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
//ищет пользователя по паролю
    public boolean checkPassword(User user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }
//проверяет совпадение паролей
    public boolean checkAuth(String username, String password) {
        return findByUsername(username).filter(user -> checkPassword(user, password)).isPresent();
    }
    //проверяет авторизацию пользователя по имени пользователя
}
