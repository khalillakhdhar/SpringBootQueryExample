package com.query.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.query.model.Teste;
import com.query.model.repository.TesteRepository;

@RestController
public class TesteController {
	@Autowired
	TesteRepository testeApi;
	
	@GetMapping("")
	public String welcome()
	{
		return "welcome to API";
	}
	@GetMapping("test")
	public List<Teste> getAlltestes()
	{
		return testeApi.findAll();
	}
	@PostMapping("test")
	public Teste addTest(@Valid @RequestBody Teste teste)
	{
		return testeApi.save(teste);
	}
	@GetMapping("test/{id}")
	public Teste getTestById(@PathVariable int id)
	{
		return testeApi.findById(id).get();
	}

}
