package edu.mum.cs544.book;

import edu.mum.cs544.IBookDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Resource
    private IBookDao bookDao;

    public List<Book> getAll() {
        return bookDao.findAll();
    }

    public void add(Book book) {
        bookDao.save(book);
    }

    public Book get(int id) {

        //return bookDao.findById(id).get();//return an Object
        return bookDao.getOne(id); // return a proxy
        //org.hibernate.LazyInitializationException: could not initialize proxy [
        // edu.mum.cs544.book.Book#1] - no Session
        //To fix it, use Filter
    }

    public void update(Book book) {
        bookDao.save(book);
    }

    public void delete(int id) {

        Book book = bookDao.findById(id).get();
        bookDao.delete(book);
    }
}
