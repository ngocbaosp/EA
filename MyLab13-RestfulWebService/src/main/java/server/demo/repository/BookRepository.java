package server.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.demo.domain.Book;
import server.demo.domain.Person;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


}
