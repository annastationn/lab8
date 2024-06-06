package se.ifmo.lab8.database.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Entity @Table(name = "addresses")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@ToString
@Builder
@RequiredArgsConstructor @AllArgsConstructor
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "zip_code")
    @Length(min = 19, message = "error.address.zip_code.length")
    String zipCode;
}
