import java.util.*;

public class BookCatalog {
    private Map<String, Book> books;

    public BookCatalog() {
        books = new HashMap<>();
    }

    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) return false;
        books.put(book.getId(), book);
        return true;
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.values().forEach(System.out::println);
    }

    public Book searchById(String id) {
        return books.get(id);
    }

    public Book searchByTitle(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) return book;
        }
        return null;
    }

    public boolean updateBook(String id, String title, String author, String genre, BookStatus status) {
        Book book = books.get(id);
        if (book == null) return false;

        if (!title.isEmpty()) book.setTitle(title);
        if (!author.isEmpty()) book.setAuthor(author);
        if (!genre.isEmpty()) book.setGenre(genre);
        if (status != null) book.setStatus(status);

        return true;
    }

    public boolean deleteBook(String id) {
        return books.remove(id) != null;
    }
}
