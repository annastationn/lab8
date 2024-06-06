package se.ifmo.lab8.configuration;
//аннотация lombok упрощает создание гет/сет
import lombok.Getter;
import lombok.Setter;
import se.ifmo.lab8.database.model.User;
import se.ifmo.lab8.localization.Localization;

import java.util.Optional;

//RuntimeConfiguration предоставляет статические поля для хранения информации
public class RuntimeConfiguration {
    @Getter @Setter
    private static volatile String username;

    @Getter @Setter
    private static volatile String password;

    @Getter @Setter
    private static volatile Optional<User> user = Optional.empty();

    @Getter @Setter
    private static volatile Localization.Type localizationType = Localization.Type.DEFAULT;
}
