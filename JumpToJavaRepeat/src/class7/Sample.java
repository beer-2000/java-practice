package class7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
        int[] result = Arrays.stream(data)  // IntStream을 생성한다.
            .boxed()  // IntStream을 Stream<Integer>로 변경한다.
            .filter((a) -> a % 2 == 0)  //  짝수만 걸러낸다.
            .distinct()  // 중복을 제거한다.
            .sorted(Comparator.reverseOrder())  // 역순으로 정렬한다.
            .mapToInt(Integer::intValue)  // Stream<Integer>를 IntStream으로 변경한다.
            .toArray()  // int[] 배열로 반환한다.
            ;
        List<Integer> list = Arrays.stream(data)  // IntStream을 생성한다.
            .boxed()  // IntStream을 Stream<Integer>로 변경한다.
            .filter((a) -> a % 2 == 0)  //  짝수만 걸러낸다.
            .distinct()  // 중복을 제거한다.
            .sorted(Comparator.reverseOrder())  // 역순으로 정렬한다.
//            .mapToInt(Integer::intValue)
            .collect(Collectors.toList());
        System.out.println(list);
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        ArrayList<Integer> arrayLis2 = new ArrayList<>(Arrays.asList(result));
    }
}