package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InterceptorUitl {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");

        // 顺序流
        list.stream().forEachOrdered(
                item -> System.out.println(item)
        );

    }
}
