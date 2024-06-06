package se.ifmo.lab8.gui.controller.table;

import org.aspectj.weaver.ast.Or;
import se.ifmo.lab8.database.model.Organization;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//класс для работы с данными об организациях в табличном формате, осуществляет фильтрацию и сортировку по различным критериям
public class OrganizationTable {
    private List<Organization> bands;

    public OrganizationTable(List<Organization> bands) {
        this.bands = bands;
    }

    //фильтрация списка орг по заданному условию
    public List<Organization> filterBands(java.util.function.Predicate<Organization> condition) {
        return bands.stream()
                //преобразует бандс в поток данных стрим
                .filter(condition)
                //фильтрует, оставляя только то, что удовлетворяет условию
                .collect(Collectors.toList());
        //собирает и возвращает
    }

    //сортировка списка орг по заданному компаратору
    public List<Organization> sortBands(Comparator<Organization> comparator) {
        return bands.stream()
                .sorted(comparator)
                //сортирует элементы с помощью компаратора
                .collect(Collectors.toList());
        //собирает и возвращает
    }

    //фильтрует по имени
    public List<Organization> filterByName(String name) {
        return filterBands(band -> band.getName().equalsIgnoreCase(name));
    }

    //сортирует по годовому обороту
    public List<Organization> sortByParticipants(boolean ascending) {
        return ascending ? sortBands(Comparator.comparingDouble(Organization::getAnnualTurnover))
                : sortBands(Comparator.comparingDouble(Organization::getAnnualTurnover).reversed());
    }

    //сортирует по дате создания
    public List<Organization> sortByCreationDate(boolean ascending) {
        return ascending ? sortBands(Comparator.comparing(Organization::getCreationDate))
                : sortBands(Comparator.comparing(Organization::getCreationDate).reversed());
    }
}

