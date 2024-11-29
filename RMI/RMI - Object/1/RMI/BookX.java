package RMI;
import java.io.Serializable;

public class BookX implements Serializable {
    private String id;
    private String title;
    private String author;
    private int yearPublished;
    private String genre;
    private String code;
    private static final long serialVersionUID = 20241124L;
    public BookX() {
        this.id = "";
        this.title = "";
        this.author = "";
        this.yearPublished = 0;
        this.genre = "";
        this.code = "";
    }
    public BookX(String id, String title, String author, int yearPublished, String genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BookX{" + "id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", genre=" + genre + ", code=" + code + '}';
    }
    
}