package com.example.god4.demos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
  @Autowired
  private BookRepository repo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Book> findItems() {
    return repo.findAll();
  }
  
  @RequestMapping(value = "/{bookid}",method = RequestMethod.GET)
  public Book findone(@PathVariable Integer bookid) {
    return  repo.findOne(bookid);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Book addItem(@RequestBody Book item) {
    item.setBookId(null);
    return repo.saveAndFlush(item);
  }
  
  @RequestMapping(value = "/{bookid}", method = RequestMethod.POST)
  public Book updateItem(@RequestBody Book updatedItem, @PathVariable Integer bookid) {
    updatedItem.setBookId(bookid);
    return repo.saveAndFlush(updatedItem);
  }
  
  @RequestMapping(value = "/{bookid}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Integer bookid) {
    repo.delete(bookid);
  }
}