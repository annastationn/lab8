package se.ifmo.lab8.database.model;

import jakarta.persistence.*;
//либа для работы с БД
import lombok.*;
import lombok.experimental.FieldDefaults;
//либа для генерации геттеров и сеттеров
import org.hibernate.validator.constraints.Length;
//валидация длины строк

@Entity @Table(name = "addresses")
//Entity сущность в БД, Table данные этого класса в таблице addresses
@FieldDefaults(level = AccessLevel.PRIVATE)
//все поля по умолчанию приватные
@Getter @Setter
@ToString
@Builder
@RequiredArgsConstructor @AllArgsConstructor
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
//уникальный идентификатор для каждого объекта + поле первичный ключ в БД
    @Column(name = "zip_code")
    //зип код - почтовый индекс
    @Length(min = 19, message = "error.address.zip_code.length")
        //мин 19 символов, иначе ошибка
    String zipCode;
}
