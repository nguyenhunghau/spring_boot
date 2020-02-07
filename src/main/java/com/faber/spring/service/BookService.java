package com.faber.spring.service;

import com.faber.spring.model.db2.Book;
import com.faber.spring.repository.db2.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thuan
 */
@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;

    @Transactional("secondTransactionManager")
    public List<Book> getAllBooks() {
        Book book = new Book("hoang", 14);
        repository.save(book);
        return (List<Book>) repository.findAll();
    }
    
    public Book getBookById(int id) {
        return repository.findById(id);
    }
    
    public List<Book> getBookByNameAndPrice(String name, int price) {
        return repository.findByNameAndPrice(name, price);
    }
     
    public List<Book> getBookByNameAndPriceProcedure(String name, Integer price) {
        return repository.findByNameAndPriceStoredProcedure(name, price);
    }

    public void deleteBook(int id) {
        repository.deleteById(id);
    }
}
