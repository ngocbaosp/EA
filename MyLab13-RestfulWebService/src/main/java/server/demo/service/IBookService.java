package server.demo.service;

import org.springframework.stereotype.Service;
import server.demo.domain.Book;
import server.demo.domain.Person;

import java.util.List;

@Service
public interface IBookService {

    List<Book> getAll();
    Book getOne(Integer id);
    Integer add(Book obj);
    void update(Book obj);
    void delete(Integer id);
}
