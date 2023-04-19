package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            numbers.add(random.nextInt(101));
        }
        double average;
        long startTime = 0;
        long endTime = 0;

        // 일반 스트림
        startTime = System.nanoTime();
        average = numbers.stream()
                .mapToInt(number -> {
//                    System.out.println(Thread.currentThread().getName());
                    return number;
                })
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        System.out.println("average : " + average + ", 일반 처리 시간 : " + (endTime - startTime) + "ns");

        System.out.println();
        System.out.println();

        // 병렬 스트림
        startTime = System.nanoTime();
        average = numbers.parallelStream()
                .mapToInt(number -> {
//                    System.out.println(Thread.currentThread().getName());
                    return number;
                })
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        System.out.println("average : " + average + ", 병렬 처리 시간 : " + (endTime - startTime) + "ns");
    }
}
