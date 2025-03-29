import java.util.Scanner;

public class BookManagementUI {
    private static Scanner sc = new Scanner(System.in);
    private static BookCatalog catalog = new BookCatalog();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Book Management System ---");
            System.out.println("1. Add Book\n2. View Books\n3. Search Book\n4. Update Book\n5. Delete Book\n6. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addBook();
                case 2 -> catalog.viewAllBooks();
                case 3 -> searchBook();
                case 4 -> updateBook();
                case 5 -> deleteBook();
                case 6 -> {
                    System.out.println("Exiting..."); 
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = sc.nextLine();
        if (catalog.searchById(id) != null) {
            System.out.println("Book ID already exists!");
            return;
        }

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        System.out.print("Enter Status (AVAILABLE / CHECKED_OUT): ");
        BookStatus status = BookStatus.valueOf(sc.nextLine().toUpperCase());

        Book book = new Book(id, title, author, genre, status);
        catalog.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void searchBook() {
        System.out.print("Search by (1) ID or (2) Title? ");
        int opt = sc.nextInt(); sc.nextLine();
        Book book = null;
        if (opt == 1) {
            System.out.print("Enter ID: ");
            book = catalog.searchById(sc.nextLine());
        } else if (opt == 2) {
            System.out.print("Enter Title: ");
            book = catalog.searchByTitle(sc.nextLine());
        }

        if (book == null) System.out.println("Book not found.");
        else System.out.println(book);
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String id = sc.nextLine();
        if (catalog.searchById(id) == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("Enter new Title (leave empty to keep): ");
        String title = sc.nextLine();

        System.out.print("Enter new Author (leave empty to keep): ");
        String author = sc.nextLine();

        System.out.print("Enter new Genre (leave empty to keep): ");
        String genre = sc.nextLine();

        System.out.print("Enter new Status (AVAILABLE / CHECKED_OUT or leave empty to keep): ");
        String statusInput = sc.nextLine();
        BookStatus status = statusInput.isEmpty() ? null : BookStatus.valueOf(statusInput.toUpperCase());

        if (catalog.updateBook(id, title, author, genre, status))
            System.out.println("Book updated successfully.");
        else
            System.out.println("Update failed.");
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String id = sc.nextLine();
        if (catalog.deleteBook(id))
            System.out.println("Book deleted successfully.");
        else
            System.out.println("Book not found.");
    }
}
