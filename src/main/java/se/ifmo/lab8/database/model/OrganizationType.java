package se.ifmo.lab8.database.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public enum OrganizationType {
    COMMERCIAL("Коммерческая"),
    GOVERNMENT("Государственная"),
    TRUST("Доверенная"),
    PRIVATE_LIMITED_COMPANY("Закрытое акционерное общество"),
    OPEN_JOINT_STOCK_COMPANY("Открытое акционерное общество");

    String type;
}