package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListPractice {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        // ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
//            arrayList.add(0, String.valueOf(i)); // 시작 위치 삽입
            arrayList.add(String.valueOf(i)); // 끝 위치 삽입
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린 시간 : " + (endTime - startTime) + "ns");

        // LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
//            linkedList.add(0, String.valueOf(i)); // 시작 위치 삽입
            linkedList.add(0, String.valueOf(i)); // 끝 위치 삽입
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린 시간 : " + (endTime - startTime) + "ns");

        // Vector
        Vector<String> vector = new Vector<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
//            vector.add(0, String.valueOf(i)); // 시작 위치 삽입
            vector.add(0, String.valueOf(i)); // 끝 위치 삽입
        }
        endTime = System.nanoTime();
        System.out.println("Vector 걸린 시간 : " + (endTime - startTime) + "ns");

        // 동기화된 ArrayList
        List<String> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());
        startTime = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
//            synchronizedArrayList.add(0, String.valueOf(i)); // 시작 위치 삽입
            synchronizedArrayList.add(String.valueOf(i)); // 끝 위치 삽입
        }
        endTime = System.nanoTime();
        System.out.println("동기화된 ArrayList 걸린 시간 : " + (endTime - startTime) + "ns");
    }
}
