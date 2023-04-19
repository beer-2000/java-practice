package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelect {
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
            String sql = "SELECT id, name, password, age, email FROM user WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "한겨울");

            // SQL문 실행 후, ResultSet으로 데이터 읽기
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getInt("age"),
                        resultSet.getString("email")
                );
                System.out.println(user);
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
