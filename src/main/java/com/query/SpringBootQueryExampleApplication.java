package com.query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.query.model.Tutorial;
import com.query.model.repository.TutorialRepository;

@SpringBootApplication
public class SpringBootQueryExampleApplication implements CommandLineRunner {
@Autowired
TutorialRepository tr;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootQueryExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Date date1 = new SimpleDateFormat("yyyy-MMdd").parse("2022-03-11");
		Date date2 = new SimpleDateFormat("yyyy-MMdd").parse("2022-04-26");
		Date date3 = new SimpleDateFormat("yyyy-MMdd").parse("2022-05-19");
		tr.save(new Tutorial("spring boot v1", "les base de Sp boot", 1, false, date1));
		tr.save(new Tutorial("java 1","cours java",0,true,date2));
		tr.save(new Tutorial("JSF", "cours JSF 2.0", 1, true, date3));
		List<Tutorial> mylist=tr.findAll();
		show(mylist);
		System.out.println("liste des tutos publié");
		List<Tutorial> publie=tr.findByPublished(true);
		show(publie);
		System.out.println("recherche par titre");
		List<Tutorial> titres=tr.findByTitleLike("java");
		show(titres);
		System.out.print("tutos >=1 (level)");
		List<Tutorial> listleveled=tr.findByLevelGreaterThanEqual(1);
		show(listleveled);
		
		
		
		
		
	}
	private void show(List<Tutorial> tutorials) {
		tutorials.forEach(System.out::println); // afficher les elements de foreach
		
	
	
	}

}
