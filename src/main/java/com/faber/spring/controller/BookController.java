package com.faber.spring.controller;

import com.faber.spring.model.db2.Book;
import com.faber.spring.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Thuan
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getListBook")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = (List<Book>) bookService.getAllBooks();
        return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
    }

    @GetMapping("/getBook")
    public ResponseEntity<Book> getAllBooks(@RequestParam("id") int id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/getBookByNameAndPrice")
    public ResponseEntity<List<Book>> getBookByNameAndPrice(@RequestParam("name") String name, @RequestParam("price") int price) {
        List<Book> list = bookService.getBookByNameAndPrice(name, price);
        return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
    }
    
    @GetMapping("/getBookByNameAndPriceStoreProcedure")
    public ResponseEntity<List<Book>> getBookByNameAndPriceStoreProcedure(@RequestParam("name") String name, @RequestParam("price") Integer price) {
        List<Book> list = bookService.getBookByNameAndPriceProcedure(name, price);
        return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
    }
}
