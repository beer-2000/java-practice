package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDelete {
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
            String sql = "DELETE FROM board WHERE writer = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "winter");

            // SQL문 실행
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("삭제된 행 수 : " + affectedRows);

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
