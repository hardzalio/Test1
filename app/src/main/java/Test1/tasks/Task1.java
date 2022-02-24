package Test1.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public void execLists() {
        List<String> persons = initTenPersons();
        printItems("Stwórz listę zawierającą 10 stringów", persons);
        List<String> subListFirstLast = getSubListFirstLast(persons);
        printItems(" Pobierz z niej 3 pierwsze i 3 ostatnie elementy", subListFirstLast);
        List<String> subListNewName = insertItemAtPositionFive(subListFirstLast);
        printItems(" Wstaw nowy element na pozycji 5", subListNewName);
        List<String> subListMiddle = getSubListMiddle(subListNewName);// we pass link to RAM into the method
        printItems(" Usuń z niej 3 pierwsze i 3 ostatnie elementy", subListMiddle);
        addSixItems(subListMiddle);
        printItems(" Stwórz drugą listę zawierająca 6 nowych imion i dodaj ją do pierwszej listy", subListMiddle);
        List<String> subListSortAsc = getAscSortedList(subListFirstLast);
        printItems(" Posortuj pierwsza listę alfabetycznie rosnąco", subListSortAsc);
        List<String> subListSortDesc = getDescSortedList(subListFirstLast);
        printItems(" Posortuj pierwsza listę alfabetycznie malejąco", subListSortDesc);

    }

    private List<String> initTenPersons() {
        return List.of("Jacek", "Agnieszka", "Olek", "Michal", "Jan", "Daniel", "Asia", "Gosia", "Radek", "Lukasz");
    }

    private List<String> getSubListFirstLast(List<String> items) {
        int firstLimit = 3;
        int secondLimit = 6;
        List<String> result = new ArrayList();
        for (int index = 0; index < items.size(); index++) {
            if (index < firstLimit || index > secondLimit) {
                result.add(items.get(index));
            }
        }
        return result;
    }

    private List<String> getSubListMiddle(List<String> items) {
        int firstLimit = 3;
        int secondLimit = 6;
        List<String> result = new LinkedList();
        for (int index = 0; index < items.size(); index++) {
            if (index > firstLimit && index < secondLimit) {
                result.add(items.get(index));
            }
        }
        return result;
    }

    private List<String> insertItemAtPositionFive(List<String> items) {
        List<String> result = new LinkedList(items);
        result.add(5, "Andrzej");
        return result;
    }

    private void addSixItems(List<String> items) {
        List<String> result = initSixPersons();
        items.addAll(result);

    }

    private List<String> initSixPersons() {
        return List.of("Dawid", "Alan", "Ted", "Ed", "Jack", "Mark");
    }

    private List<String> getAscSortedList(List<String> items) {
        List<String> sortedList = items.stream().sorted().collect(Collectors.toList());
        return sortedList;
    }

    private List<String> getDescSortedList(List<String> items) {
        List<String> sortedList = items.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return sortedList;
    }

    private void printItems(String descriptionString, List<String> items) {
        System.out.print(descriptionString + ": ");
        System.out.println(items);
    }
}
