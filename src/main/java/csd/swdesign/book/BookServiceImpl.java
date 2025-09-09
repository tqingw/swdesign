package csd.swdesign.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private ArrayList<Book> books = new ArrayList<Book>();
    // This is just a simple implementation for testing
    //A real-world implementation should be interacting with a database for books
    public BookServiceImpl(){
        books.add(new Book("To Kill a Mockingbird"));
        books.add(new Book("The Great Gatsby"));
        books.add(new Book("The Diary Of A Young Girl"));
    }
    
    @Override
    public List<Book> listBooks() {
        return books;
    }

    
    @Override
    public Book getBook(Long id){
        for(Book book : books){
            if(book.getId().equals(id))
                return book;
        }
        throw new BookNotFoundException(id);
    }
    
  
    @Override
    public Book addBook(Book book) {
        Book newBook = new Book(book.getTitle());
        books.add(newBook);
        return newBook;
    }
    
    @Override
    public Book updateBook(Long id, Book newBookInfo){
        for(Book book : books){
            if(book.getId().equals(id)){
                book.setTitle(newBookInfo.getTitle());
                return book;
            }
        }
        
        throw new BookNotFoundException(id);
    }

    
    /**
     * TODO: Activity 2
     * Removes a book from the system by its ID.
     * 
     * @param id the unique identifier of the book to delete
     * @return the deleted book object for confirmation
     * @throws BookNotFoundException if no book exists with the given ID
     */
    @Override
    public Book deleteBook(Long id){
        return null;
    }
}