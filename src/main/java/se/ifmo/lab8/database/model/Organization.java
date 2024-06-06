package se.ifmo.lab8.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Table(name = "organizations")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    //вид связи много к одному
    @JoinColumn(nullable = false)
    User user;

    @NotNull(message = "error.organization.name.null")
    @NotBlank(message = "error.organization.name.blank")
    String name;

    @ManyToOne(cascade = CascadeType.ALL)
    //вид связи много к одному
    @NotNull(message = "error.organization.coordinates.null")
    Coordinates coordinates;

    @Column(nullable = false, updatable = false, name = "creation_date")
    ZonedDateTime creationDate = ZonedDateTime.now(ZoneId.systemDefault());
    //не может быть обновлено после создания

    @Range(min = 0, message = "error.organization.annual_turnover.range")
    @NotNull(message = "error.organization.annual_turnover.null")
    Float annualTurnover;

    @Column(name = "organization_type")
    @Enumerated(EnumType.STRING)
    OrganizationType organizationType;

    @OneToOne(cascade = CascadeType.ALL)
    //вид связи один к одному
    @NotNull(message = "error.organization.official_address.null")
    Address officialAddress;
}
