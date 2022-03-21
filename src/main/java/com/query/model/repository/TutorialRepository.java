package com.query.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.query.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	@Query("SELECT t FROM Tutorial t order by title")
	List<Tutorial> findAll(); // select * ( elle redéfinie la methode findAll)

	@Query("SELECT t FROM Tutorial t WHERE t.published=?1") // ?1 premier placeholder => 1er argument de la méthode annoté
	List<Tutorial> findByPublished(boolean isPublished); 

	@Query("SELECT t FROM Tutorial t WHERE t.title LIKE %?1%") // LIKE query %element%
	List<Tutorial> findByTitleLike(String title);

	@Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))")  // ?1 placeholder de title
	// concat pour concaténation de title.toLowerCase avec %
	List<Tutorial>	findByTitleLikeCaseInsensitive(String title);
	
	@Query("SELECT t FROM Tutorial t WHERE t.level >= ?1")
	List<Tutorial>	findByLevelGreaterThanEqual(int level); 
	@Query("SELECT t FROM Tutorial t WHERE	t.createdAt >= ?1") 
	List<Tutorial> findByDateGreaterThanEqual(Date date);
	
}
