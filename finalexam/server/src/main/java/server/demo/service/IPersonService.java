package server.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.demo.domain.Person;
import server.demo.repository.PersonRepository;

import java.util.List;

@Service
public interface IPersonService {

    List<Person> getAll();
    Person getOne(Long id);
    Long addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Long id);
}
