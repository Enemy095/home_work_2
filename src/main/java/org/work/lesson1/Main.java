package org.work.lesson1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> competitors = new ArrayList<>(Arrays.asList("Ivan 5", "Petr 3",
                "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"));
        showWinner(competitors);
        System.out.println(getTop10(testPosts()));
    }

    //   PART 1
    public static void showWinner(List<String> competitors) {
        Map<String, Integer> competitorsMap = new LinkedHashMap<>(16, 0.75f, true);
        for (String competitor : competitors) {
            int index = competitor.indexOf(" ");
            if (index != -1) {
                String afterSpace = competitor.substring(competitor.lastIndexOf(" ") + 1);
                String name = competitor.substring(0, index);
                Integer score = Integer.valueOf(afterSpace);
                competitorsMap.put(name, competitorsMap.getOrDefault(name, 0) + score);
            } else {
                System.out.println("имя или балл указаны не верно");
            }
        }
        competitorsMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }


    //  Part 2
    public static List<Post> testPosts(){
        return new ArrayList<>(Arrays.asList(new Post("jj", 33),
                new Post("a", 200),
                new Post("b", 33),
                new Post("c", 3434),
                new Post("d", 333),
                new Post("e", 3454),
                new Post("f", 344),
                new Post("g", 323),
                new Post("h", 34234),
                new Post("i", 3),
                new Post("j", 1223),
                new Post("k", 3554),
                new Post("l", 34354),
                new Post("m", 7654),
                new Post("n", 75443),
                new Post("o", 67),
                new Post("p", 87),
                new Post("q", 6785),
                new Post("r", 54333)));
    }

    public static List<Post> getTop10(List<Post> posts){
        PriorityQueue<Post> top10 = new PriorityQueue<>();
        posts.forEach(post -> {
            top10.add(post);
            if (top10.size() > 10) {
                top10.poll();
            }
        });
        return new  ArrayList<>(top10);
    }
}
