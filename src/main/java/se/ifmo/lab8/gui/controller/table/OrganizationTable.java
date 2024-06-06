package se.ifmo.lab8.gui.controller.table;

import org.aspectj.weaver.ast.Or;
import se.ifmo.lab8.database.model.Organization;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrganizationTable {
    private List<Organization> bands;

    public OrganizationTable(List<Organization> bands) {
        this.bands = bands;
    }

    public List<Organization> filterBands(java.util.function.Predicate<Organization> condition) {
        return bands.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public List<Organization> sortBands(Comparator<Organization> comparator) {
        return bands.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Organization> filterByName(String name) {
        return filterBands(band -> band.getName().equalsIgnoreCase(name));
    }

    public List<Organization> sortByParticipants(boolean ascending) {
        return ascending ? sortBands(Comparator.comparingDouble(Organization::getAnnualTurnover))
                : sortBands(Comparator.comparingDouble(Organization::getAnnualTurnover).reversed());
    }

    public List<Organization> sortByCreationDate(boolean ascending) {
        return ascending ? sortBands(Comparator.comparing(Organization::getCreationDate))
                : sortBands(Comparator.comparing(Organization::getCreationDate).reversed());
    }
}

