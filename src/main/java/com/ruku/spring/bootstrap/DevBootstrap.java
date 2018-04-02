package com.ruku.spring.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ruku.spring.model.Author;
import com.ruku.spring.model.Book;
import com.ruku.spring.repositories.AuthorRepository;
import com.ruku.spring.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}

	private void initData() {
		
		Author nemsothea = new Author("Nem","Sothea");
		Book springboot = new Book("How to handle springboot ","2018","Vansabean");
		nemsothea.getBooks().add(springboot);
		springboot.getAuthors().add(nemsothea);
		//save Data
		authorRepository.save(nemsothea);
		bookRepository.save(springboot);
		
		
		
		Author vans = new Author("Vansa","Bean");
		Book kap = new Book("How to save the girls ","2017","Vansa bean Battambong");
		vans.getBooks().add(kap);
		authorRepository.save(vans);
		bookRepository.save(kap);
		
	}	
}
