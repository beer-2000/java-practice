package class6;

import java.io.*;

public class Sample2 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("./out.txt");
        for(int i=1; i<11; i++) {
            String data = i+" 번째 줄입니다.";
            pw.println(data);
        }
        pw.close();

        FileWriter fw2 = new FileWriter("./out.txt", true);  // 파일을 추가 모드로 연다.
        for(int i=11; i<21; i++) {
            String data = i+" 번째 줄입니다.\r\n";
            fw2.write(data);
        }
        fw2.close();

        byte[] b = new byte[100];
        FileInputStream input = new FileInputStream("./out.txt");
        input.read(b);
        System.out.println(new String(b));  // byte 배열을 문자열로 변경하여 출력
        input.close();

        BufferedReader br = new BufferedReader(new FileReader("./out.txt"));
        while(true) {
            String line = br.readLine();
            if (line==null) break;  // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나간다.
            System.out.println(line);
        }
        br.close();
    }
}
