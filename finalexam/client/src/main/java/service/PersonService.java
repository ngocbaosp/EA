package service;

import domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private RestTemplate restTemplate;
    private final String personUrl = "http://localhost:8080/person/{id}";
    private final String pplUrl = "http://localhost:8080/person/";


    public Person get(Long id) {
        return restTemplate.getForObject(personUrl, Person.class, id);
    }


    public List<Person> getAll() {
        ResponseEntity<List<Person>> response =
                restTemplate.exchange(pplUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Person>>() {
                        });
        return response.getBody();
    }
}
