package csd.swdesign.book;

import java.util.List;

/**
 * Service interface for managing book operations.
 * 
 * This interface defines the core business logic operations for book management,
 * including CRUD (Create, Read, Update, Delete) operations. Implementations of
 * this interface should handle the business rules.
 * 
 */
public interface BookService {
    
    /**
     * Retrieves all books in the system.
     * 
     * @return a list of all books currently stored in the system.
     *         Returns an empty list if no books are found.
     */
    List<Book> listBooks();
    
    /**
     * Retrieves a specific book by its unique identifier.
     * 
     * @param id the unique identifier of the book to retrieve.
     * @return the book with the specified ID
     * @throws BookNotFoundException if no book exists with the given ID
     */
    Book getBook(Long id);
    
    /**
     * Adds a new book to the system.
     * 
     * The book will be assigned a unique ID automatically. If the book
     * already has an ID, it will be ignored and a new ID will be generated.
     * 
     * @param book the book to add to the system.
     * @return the newly created book with its assigned ID
     */
    Book addBook(Book book);
    
    /**
     * Updates an existing book's information.
     * 
     * Only the book's title and other mutable properties will be updated.
     * The book's ID cannot be changed through this operation.
     * 
     * @param id the unique identifier of the book to update.
     * @param book the book object containing the updated information.
     * @return the updated book
     * @throws BookNotFoundException if no book exists with the given ID
     */
    Book updateBook(Long id, Book book);
    
    /**
     * Removes a book from the system.
     * 
     * @param id the unique identifier of the book to delete.
     * @return the deleted book object for confirmation
     * @throws BookNotFoundException if no book exists with the given ID
     */
    Book deleteBook(Long id);
}