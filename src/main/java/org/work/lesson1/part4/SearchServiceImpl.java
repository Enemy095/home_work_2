package org.work.lesson1.part4;

import java.util.*;

public class SearchServiceImpl {//implements SearchService {

    public static List<User> searchForFriendsInWidth(User me, String name) {
        if (me == null) return Collections.emptyList();

        List<User> result = new ArrayList<>();
        Queue<User> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        queue.add(me);
        visited.add(me.getId());

        while (!queue.isEmpty()) {
            User current = queue.remove();

            if (name.equals(current.getName())) {
                result.add(current);
            }

            current.getFriends().stream()
                    .filter(Objects::nonNull)
                    .filter(friend -> !visited.contains(friend.getId()))
                    .forEach(friend -> {
                        visited.add(friend.getId());
                        queue.add(friend);
                    });
        }

        return result;
    }

    public static List<User> searchForFriendsInDepth(User me, String name) {
        if (me == null) return Collections.emptyList();

        List<User> result = new ArrayList<>();
        dfs(me, name, new HashSet<>(), result);
        return result;
    }

    private static void dfs(User current, String name, Set<Long> visited, List<User> result) {
        if (current == null || !visited.add(current.getId())) {
            return;
        }

        if (name.equals(current.getName())) {
            result.add(current);
        }

        current.getFriends().stream()
                .filter(Objects::nonNull)
                .forEach(friend -> dfs(friend, name, visited, result));
    }

    public static void main(String[] args) {

        User vasilii = new User("Василий");
        User arina = new User("Арина");
        User yulya = new User("Юля");
        User evgenii = new User("Евгений");
        User konstantin = new User("Константин");
        User vladimir = new User("Владимир");
        User mariya = new User("Мария");
        User dmitrii = new User("Дмитрий");
        User anatolii = new User("Анатолий");
        User gennadii = new User("Геннадий");
        User anna = new User("Анна");
        User mikhail = new User("Михаил");
        User sergei = new User("Сергей");
        User natasha = new User("Наташа");
        User natasha2 = new User("Наташа");
        vasilii.setFriends(Arrays.asList(arina, yulya));
        arina.setFriends(Arrays.asList(vasilii, dmitrii, natasha2));
        yulya.setFriends(Arrays.asList(vasilii, evgenii));
        evgenii.setFriends(Arrays.asList(yulya));
        konstantin.setFriends(Arrays.asList(vladimir, mariya));
        vladimir.setFriends(Arrays.asList(konstantin));
        mariya.setFriends(Arrays.asList(konstantin, vasilii));
        dmitrii.setFriends(Arrays.asList(arina, anatolii, natasha));
        anatolii.setFriends(Arrays.asList(dmitrii, gennadii));
        gennadii.setFriends(Arrays.asList(anatolii));
        anna.setFriends(Arrays.asList(mikhail));
        mikhail.setFriends(Arrays.asList(sergei, anna));
        sergei.setFriends(Arrays.asList(natasha, mikhail));
        natasha.setFriends(Arrays.asList(dmitrii, sergei));
        natasha2.setFriends(Arrays.asList(arina));

        List<User> foundFriends = searchForFriendsInDepth(vasilii, "Наташа");
        System.out.println(foundFriends);
        foundFriends = searchForFriendsInWidth(vasilii, "Наташа");
        System.out.println(foundFriends);
    }
}

