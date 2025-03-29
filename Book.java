public class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private BookStatus status;

    public Book(String id, String title, String author, String genre, BookStatus status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public BookStatus getStatus() { return status; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setStatus(BookStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author +
               ", Genre: " + genre + ", Status: " + status;
    }
}
