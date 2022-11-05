package projava;

import java.util.List;

public class InterfaceSample {
    @FunctionalInterface // 実装すべきメソッドが 1 つだけの関数型インターフェースを明示している
    interface Named {
        String name();

        default String greeting() {
            return "こんにちは%sさん".formatted(name());
        }
    }

    record Student(String name, int score) implements Named {}
    record Teacher(String name, String subject) implements Named {}

    static class Passenger implements Named {
        @Override
        public String name() {
            return "通りすがり";
        }
    }

    static void message(Named named) {
        System.out.println("Hello " + named.name());
    }

    public static void main(String[] args) {
        var people = List.of(
                new Student("kis", 80),
                new Teacher("hosoya", "Math"),
                new Passenger());
        for (Named p : people) {
            System.out.println(p.greeting());
//            System.out.println("こんにちは%sさん".formatted(p.name()));
        }
        message(() -> "no name"); // 関数型インターフェースを引数に受け取るメソッドはラムダ式を使える
        message(new Student("K", 90));

        // インターフェースがない場合
        // for (var p : people) {
        //     var n = p instanceof Student s ? s.name() :
        //             p instanceof Teacher t ? t.name() :
        //                     "---";
        //     System.out.println("こんにちは%sさん".formatted(n));
        // }
    }
}
