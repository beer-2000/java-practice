package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // JDBC Driver 메모리에 등록
//            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava?&serverTimezone=UTC",
                    "root",
                    "miami0306!"
            );

            // PreparedStatement 얻기 및 값 지정
            String sql = "UPDATE board SET title = ?, content = ?, filename = ?, filedate = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "눈사람");
            preparedStatement.setString(2, "눈으로 만든 사람");
            preparedStatement.setString(3, "snowman.jpg");
            preparedStatement.setBlob(4, new FileInputStream(
                    "/Users/woozin/JavaPractice/java-practice/practice/src/main/resources/picture2.png"));
            preparedStatement.setInt(5, 3);

            // SQL문 실행
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("수정된 행 수 : " + affectedRows);

            // PreparedStatement 닫기
            preparedStatement.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    //연결 끊기
                    connection.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }
}
