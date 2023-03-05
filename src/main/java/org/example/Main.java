package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    public class Main {

        public static void main(String[] args) {

            System.out.println(getEvenNums(nums));

            Stream<Integer> stream = nums.stream();

            findMinMax(stream, Integer::compareTo, (x, y) -> System.out.printf("min: %s, max: %s%n", x, y));

            stream.close();

        }


        public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {

            List<T> items = stream.sorted(order).collect(Collectors.toList());
            if (!items.isEmpty()) {
                minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
            } else {
                minMaxConsumer.accept(null, null);
            }
        }

        public static List<Integer> nums = new ArrayList<>(List.of(1,6,31,443,2));

        public static Long getEvenNums(List<Integer> nums){
            return nums.stream().
                    filter(integer->integer % 2 == 0).
                    count();
        }
}