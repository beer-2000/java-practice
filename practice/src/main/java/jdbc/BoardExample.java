package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardExample {
    private final Scanner scanner;
    private Connection connection;

    public BoardExample() {
        this.scanner = new Scanner(System.in);
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava?&serverTimezone=UTC",
                    "root",
                    "miami0306!"
            );
        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }

    public static void main(String[] args) {
        BoardExample boardExample = new BoardExample();
        boardExample.list();
    }

    public void list() {
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("------------------------------------------");
        System.out.printf("%-6s%-23s%-16s%-40s \n", "no", "writer", "date", "title");
        System.out.println("------------------------------------------");
        readBoards();
        mainMenu();
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        System.out.println();
        switch (menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
        }
    }

    private void create() {
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        String writer = scanner.nextLine();

        System.out.println("------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        int menuNumber = scanner.nextInt();
        if (menuNumber == 1) {
            try {
                String sql = "INSERT INTO board (title, content, writer) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, content);
                preparedStatement.setString(3, writer);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
                exit();
            }
        }
        scanner.nextLine();
        list();
    }

    private void read() {
        readBoards();
        list();
    }

    private void readBoards() {
        try {
            String sql = "SELECT id, title, content, writer, date FROM board ORDER BY id DESC";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Board2 board2 = new Board2(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("writer"),
                        resultSet.getDate("date")
                );
                System.out.printf("%-6s%-23s%-16s%-40s \n",
                        board2.getId(), board2.getWriter(), board2.getDate(), board2.getTitle());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            exit();
        }
    }

    private void clear() {
        System.out.println("*** clear() 메소드 실행됨");
        list();
    }

    private void exit() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        System.out.println("종료");
        System.exit(0);
    }
}
