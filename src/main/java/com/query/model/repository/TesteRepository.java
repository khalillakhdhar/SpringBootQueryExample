package com.query.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.query.model.Teste;

public interface TesteRepository extends JpaRepository<Teste, Integer> {
List<Teste> findByNoteGreaterThan(int note);
@Query("SELECT t From Teste t WHERE note> 16 ORDER BY t.candidat")
List<Teste> findBest();
List<Teste> findByRemarque(String remarque);
List<Teste> findTop1ByNote(int note); // Select max(note) from Test

}
