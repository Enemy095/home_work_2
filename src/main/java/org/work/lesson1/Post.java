package org.work.lesson1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Post implements Comparable<Post>{
    private String text;
    private Integer likesCount;

    @Override
    public int compareTo(Post o) {
        return Integer.compare(this.likesCount, o.likesCount);
    }
}
