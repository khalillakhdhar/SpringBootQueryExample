package com.query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.query.model.Teste;
import com.query.model.Tutorial;
import com.query.model.repository.TesteRepository;
import com.query.model.repository.TutorialRepository;

@SpringBootApplication
public class SpringBootQueryExampleApplication implements CommandLineRunner {
@Autowired
TutorialRepository tr;
@Autowired
TesteRepository testesRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootQueryExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testesRepo.save(new Teste("12/03/2022", "mark", 19, "excellent"));
		testesRepo.save(new Teste("14/02/2022", "Bill gates", 10, "passable"));
		testesRepo.save(new Teste("12/12/2021", "Jeff Bezos", 9, "redoublement"));
		testesRepo.save(new Teste("12/02/2022","Jack maa", 17, "trés bien"));
		System.out.println("liste des étudiant qui ont bien passé le teste: ");
		List<Teste> lp=new ArrayList<Teste>();
		lp=testesRepo.findByNoteGreaterThan(9);
		showTestes(lp);
		System.out.println("liste des lauréats: ");
		List<Teste> Listl=new ArrayList<Teste>();
		Listl=testesRepo.findBest();
		showTestes(Listl);
		System.out.println("liste des redoublants");
		List<Teste> listrm=new ArrayList<Teste>();
		listrm=testesRepo.findByRemarque("redoublement");
		showTestes(listrm);
		

		
		
		
		
		// TODO Auto-generated method stub
//		Date date1 = new SimpleDateFormat("yyyy-MMdd").parse("2022-03-11");
//		Date date2 = new SimpleDateFormat("yyyy-MMdd").parse("2022-04-26");
//		Date date3 = new SimpleDateFormat("yyyy-MMdd").parse("2022-05-19");
//		Date date1 = new SimpleDateFormat("yyyy-MMdd").parse("2022-03-11");
//		Date date2 = new SimpleDateFormat("yyyy-MMdd").parse("2022-04-26");
//		Date date3 = new SimpleDateFormat("yyyy-MMdd").parse("2022-05-19");
//		tr.save(new Tutorial("spring boot v1", "les base de Sp boot", 1, false, date1));
//		tr.save(new Tutorial("java 1","cours java",0,true,date2));
//		tr.save(new Tutorial("JSF", "cours JSF 2.0", 1, true, date3));
//		List<Tutorial> mylist=tr.findAll();
//		show(mylist);
//		System.out.println("liste des tutos publié");
//		List<Tutorial> publie=tr.findByPublished(true);
//		show(publie);
//		System.out.println("recherche par titre");
//		List<Tutorial> titres=tr.findByTitleLike("java");
//		show(titres);
//		System.out.print("tutos >=1 (level)");
//		List<Tutorial> listleveled=tr.findByLevelGreaterThanEqual(1);
//		show(listleveled);
		
		
		
		
		
	}
	private void show(List<Tutorial> tutorials) {
		tutorials.forEach(System.out::println); // afficher les elements de foreach	
	}
	private void showTestes(List<Teste> testes) {
		testes.forEach(System.out::println); // afficher les elements de foreach	
	}
}
