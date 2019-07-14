package edu.mum.cs.springbootwebjspdemo.service;


import edu.mum.cs.springbootwebjspdemo.domain.Book;
import edu.mum.cs.springbootwebjspdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookService {

    @Autowired
    private RestTemplate restTemplate;
    private final String bookUrl = "http://localhost:8080/book/{id}";
    private final String pplUrl = "http://localhost:8080/books";
    private final String pplUrlAdd = "http://localhost:8080/book/add";
    private final String pplUrlAddRedirect = "http://localhost:8080/book/redirect";


    public Book get(Integer id) {
        return restTemplate.getForObject(bookUrl, Book.class, id);
    }
    public List<Book> getAll() {
        ResponseEntity<List<Book>> response =
                restTemplate.exchange(pplUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Book>>() {
                        });
        return response.getBody();
    }
    public void update(Book p) {
        restTemplate.put(bookUrl, p, p.getId());
    }
    public void delete(Integer id) {
        restTemplate.delete(bookUrl, id);
    }
    public Integer add(Book p) {
        restTemplate.postForLocation(pplUrlAdd, p);
        System.out.println(p.getId());
        return p.getId();

    }
    public Integer addRedirect(Person p) {
        URI uri = restTemplate.postForLocation(pplUrlAddRedirect, p);
        if (uri == null) {
            return null;
        }
        Matcher m = Pattern.compile(".*/book/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Integer.parseInt(m.group(1));
    }
}
