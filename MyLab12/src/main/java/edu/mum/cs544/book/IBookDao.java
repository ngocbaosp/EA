package edu.mum.cs544;



import edu.mum.cs544.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookDao extends JpaRepository<Book,Integer> {

    /*
    public abstract List<Book> getAll();

    public abstract void add(Book book);

    public abstract Book get(int id);

    public abstract void update(Book book);

    public abstract void delete(int bookId);

     */

}
