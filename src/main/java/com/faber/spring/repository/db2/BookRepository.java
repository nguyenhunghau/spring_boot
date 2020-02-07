package com.faber.spring.repository.db2;

import com.faber.spring.model.db2.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thuan
 */
@Repository("bookRepository")
public interface BookRepository extends CrudRepository<Book, Integer>{
    
    //This is a query method.
    Book findById(int id);
    
    List<Book> findByName(String name);
    
    @Query("SELECT b FROM Book b where b.name = :name and b.price = :price")
    public List<Book> findByNameAndPrice(@Param("name") String name, @Param("price") int price);
    
    @Query(value = "call GET_ALL_BOOK(:name, :price)", nativeQuery = true)
    List<Book> findByNameAndPriceStoredProcedure(@Param("name") String name, @Param("price") int price);
    
}
