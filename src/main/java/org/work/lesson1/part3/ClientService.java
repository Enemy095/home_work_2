package org.work.lesson1.part3;

import java.util.*;
import java.util.stream.Collectors;

public class ClientService {
    public Integer sumAge1(List<Client> clients) {
        return clients.stream()
                .mapToInt(Client::getAge)
                .sum();
    }

    public Set<String> exercise2(List<Client> clients) {
        return clients.stream()
                .map(Client::getName)
                .collect(Collectors.toSet());
    }

    public boolean isContainsClient3(int Age, List<Client> clients) {
        return clients.stream()
                .anyMatch(c -> c.getAge() > Age);
    }

    public Map<Integer, String> exercise4(List<Client> clients) {
        return clients.stream()
                .collect(Collectors.toMap(Client::getId, Client::getName));
    }

    public Map<Integer, List<Client>> exercise5(List<Client> clients) {
        Map<Integer, List<Client>> map = new HashMap<>();
        return clients.stream()
                .collect(Collectors.groupingBy(Client::getAge));
    }

    public String exercise6(List<Client> clients) {

        return clients.stream()
                .map(Client::getPhones)
                .flatMap(List::stream)
                .map(Phone::getNumber)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
    }

    public Optional<Client> exercise7(List<Client> clients) {
        return clients.stream()
                .filter(c -> c.getPhones().stream()
                        .filter(Objects::nonNull)
                        .anyMatch(phone -> phone.getType().equals("STATIONARY_PHONE")))
                .max(Comparator.comparingInt(Client::getAge));
    }
}
