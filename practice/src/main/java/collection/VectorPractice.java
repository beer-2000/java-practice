package collection;


import collection.mission.SimpleArrayList;
import collection.mission.SimpleList;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorPractice {
    public static void main(String[] args) {
//        List<Board> list = new Vector<>();
        List<Board> list = new ArrayList<>();

        Thread threadA = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    Thread thread = Thread.currentThread();
//                    System.out.println(thread.getName() + " - " + i + "번째 작업 중");
                    list.add(new Board(list.size(), "제목" + i, "내용" + i, "글쓴이" + i));
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println(list.size() - 1 + "번째 작업 완료");
//                    if (new Board(i, "test", "test", "test").equals((list.get(list.size() - 1)))) {
                    if ((list.get(list.size() - 1)).equals(new Board(i, "test", "test", "test"))) {
                        System.out.println("error");
                        throw new IllegalArgumentException("잘못된 저장입니다.");
                    }
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                for (int i = 1001; i <= 2000; i++) {
                    Thread thread = Thread.currentThread();
//                    System.out.println(thread.getName() + " - " + i + "번째 작업 중");
                    list.add(new Board(list.size(), "제목" + i, "내용" + i, "글쓴이" + i));
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println(list.size() - 1 + "번째 작업 완료");
//                    if (new Board(i, "test", "test", "test").equals((list.get(list.size() - 1)))) {
                    if ((list.get(list.size() - 1)).equals(new Board(i, "test", "test", "test"))) {
                        System.out.println("error");
                        throw new IllegalArgumentException("잘못된 저장입니다.");
                    }
                }
            }
        };

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (Exception ignored) {
        }

//        for (int i = 0; i < list.size(); i++) {
////            System.out.println(i + "번째 요소 : " + list.get(i));
//            if (i != list.get(i).getId()) {
//                System.out.println(i + "번째는 null 입니다.");
//            }
//        }

        System.out.println("총 객체 수 : " + list.size());
    }
}

class Board {
    private int id;
    private String subject;
    private String content;
    private String writer;

    public Board(int id, String subject, String content, String writer) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.writer = writer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public boolean equals(int id) {
        return this.id == id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id + "번째 Board";
    }
}
