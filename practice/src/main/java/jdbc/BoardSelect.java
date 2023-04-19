package jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelect {
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
            String sql = "SELECT id, title, content, writer, date, filename, filedate FROM board WHERE writer=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "winter");

            // SQL문 실행 후, ResultSet으로 데이터 읽기
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Board board = new Board(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("writer"),
                        resultSet.getDate("date"),
                        resultSet.getString("filename"),
                        resultSet.getBlob("filedate")
                );
                System.out.println(board);

                Blob blob = board.getFiledate();
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    OutputStream outputStream = new FileOutputStream(
                            "/Users/woozin/JavaPractice/java-practice/practice/src/main/resources/"
                                    + board.getFilename());
                    inputStream.transferTo(outputStream);
                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();
                }
            }
            resultSet.close();

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
