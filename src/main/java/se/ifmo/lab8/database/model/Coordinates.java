package se.ifmo.lab8.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "coordinates")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@ToString
@Builder
@RequiredArgsConstructor @AllArgsConstructor
public class Coordinates {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "error.coordinates.x.null")
    Long x;

    Integer y;
}
