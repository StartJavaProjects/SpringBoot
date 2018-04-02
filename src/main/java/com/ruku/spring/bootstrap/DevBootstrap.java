package com.ruku.spring.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ruku.spring.model.Author;
import com.ruku.spring.model.Book;
import com.ruku.spring.model.Publisher;
import com.ruku.spring.repositories.AuthorRepository;
import com.ruku.spring.repositories.BookRepository;
import com.ruku.spring.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}

	private void initData() {
		Publisher publisher = new Publisher();
		publisher.setName("Vansa");
		publisherRepository.save(publisher);
		
		Author nemsothea = new Author("Nem","Sothea");
		Book springboot = new Book("How to handle springboot ","2018",publisher);
		nemsothea.getBooks().add(springboot);
		springboot.getAuthors().add(nemsothea);
		//save Data
		authorRepository.save(nemsothea);
		bookRepository.save(springboot); 
		
		
		//create new object
		Author vans = new Author("Vansa","Bean");
		Book kap = new Book("How to save the girls ","2017",publisher);
		vans.getBooks().add(kap);
		authorRepository.save(vans);
		bookRepository.save(kap);
		
	}	
}
