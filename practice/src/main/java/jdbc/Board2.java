package jdbc;

import java.util.Date;
import java.util.Objects;

public final class Board2 {
    private final int id;
    private final String title;
    private final String content;
    private final String writer;
    private final Date date;

    public Board2(int id, String title, String content, String writer, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board2 board = (Board2) o;
        return id == board.id && Objects.equals(title, board.title) && Objects.equals(content,
                board.content) && Objects.equals(writer, board.writer) && Objects.equals(date,
                board.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, writer, date);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", date=" + date +
                '}';
    }
}
