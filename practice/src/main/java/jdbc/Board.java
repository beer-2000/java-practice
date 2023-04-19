package jdbc;

import java.sql.Blob;
import java.util.Date;
import java.util.Objects;

public final class Board {
    private final int id;
    private final String title;
    private final String content;
    private final String writer;
    private final Date date;
    private final String filename;
    private final Blob filedate;

    public Board(int id, String title, String content, String writer, Date date, String filename, Blob filedate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
        this.filename = filename;
        this.filedate = filedate;
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

    public String getFilename() {
        return filename;
    }

    public Blob getFiledate() {
        return filedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board board = (Board) o;
        return id == board.id && Objects.equals(title, board.title) && Objects.equals(content,
                board.content) && Objects.equals(writer, board.writer) && Objects.equals(date,
                board.date) && Objects.equals(filename, board.filename) && Objects.equals(filedate,
                board.filedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, writer, date, filename, filedate);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", date=" + date +
                ", filename='" + filename + '\'' +
                ", filedate=" + filedate +
                '}';
    }
}
