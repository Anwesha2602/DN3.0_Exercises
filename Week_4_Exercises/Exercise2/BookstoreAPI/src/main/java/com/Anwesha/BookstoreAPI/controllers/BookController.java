package com.Anwesha.BookstoreAPI.controllers;
import org.springframework.web.bind.annotation.*;
import com.Anwesha.BookstoreAPI.entity.Book;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/books",produces="application/json")//only return in JSON format
public class BookController {

    private final Map<Long, Book> bookRepository = new HashMap<>(); //mapping id to books
    private long idCounter = 1L; //auto increment book id

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(new ArrayList<>(bookRepository.values()));//return list of books
    }
   
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
    	book.setId(idCounter++);
    	bookRepository.put(book.getId(), book);
        return  ResponseEntity.ok(book);//create a book
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id,@RequestBody Book book) {
    	bookRepository.put(id, book);
        return  ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id) {
    	Book book = bookRepository.get(id);
    	if(book!=null) { //if id present then only delete
	    	bookRepository.remove(id);
	        return  ResponseEntity.ok("Deleted");
    	}
    	else {
    		return  ResponseEntity.ok("Book with id = "+ id +" doesn't exist!");
    	}
    }
}
