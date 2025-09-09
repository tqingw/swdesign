package csd.swdesign;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import csd.swdesign.book.*;

@SpringBootApplication
public class SwDesignApplication {

    private static final Logger log = LoggerFactory.getLogger(SwDesignApplication.class);

    public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(SwDesignApplication.class, args);

        // print out the book's info to the terminal
		BookController controller = ctx.getBean(BookController.class);
        List<Book> books = controller.getBooks();
        for(Book book : books){
            log.info("Book: " + book.getTitle());
        }

        // TODO: Activity 3 - understand how to use RestTemplate
        // Uncomment the following code to observe and experiment with
        // the use of RestTemplate to consume the web service
        
        // // Use BookClient which makes use of Spring's RestTemplate to consume the web service
        // BookClient client = ctx.getBean(BookClient.class);

        // // Our web service endpoint
        // String URI = "http://localhost:8080/books";

        // // Perform a GET request
        // Book book = client.getBook(URI, 1L);
        // log.info("[RestTemplate] GET book: " + book.getTitle());

        // // Perform a POST request to add a new book
        // Book newBook = new Book();
        // newBook.setTitle("Gone With The Wind");
        // Book returnedBook = client.addBook(URI, newBook);
        // log.info("[RestTemplate] POST book: " + returnedBook.getTitle());

    }
    
}
