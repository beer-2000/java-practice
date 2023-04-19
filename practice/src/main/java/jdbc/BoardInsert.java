package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardInsert {
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
            String sql = "INSERT INTO board (title, content, writer, filename, filedate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "눈 오는 날");
            preparedStatement.setString(2, "함박눈이 내려요.");
            preparedStatement.setString(3, "winter");
            preparedStatement.setString(4, "snow3.jpg");
            preparedStatement.setBlob(5, new FileInputStream(
                    "/Users/woozin/JavaPractice/java-practice/practice/src/main/resources/picture.png"));

            // SQL문 실행
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("저장된 행 수 : " + affectedRows);

            // id 값 얻기
            if (affectedRows == 1) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("저장된 id : " + id);
                }
                resultSet.close();
            }

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
