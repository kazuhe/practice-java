package projava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachListSample {
    public static void main(String[] args) {
        // List
        var strs = List.of("apple", "banana", "grape");
        for (String str : strs) {
            System.out.println(str);
        }

        // Array
        var nums = new int[]{2, 3, 5, 7};
        for (int num : nums) {
            System.out.println(num);
        }

        // 条件を元に List から新しい List をつくる
        var data = List.of("hogehoge", "foo", "fugafuga");
        var result = data.stream()
                .filter(s -> s.length() >= 5)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(result);
    }
}
