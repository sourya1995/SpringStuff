package com.club.eliteclub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.club.eliteclub.entity.EliteClub;

public interface EliteClubRepository extends JpaRepository<EliteClub, Long>{
	 
	@Query("SELECT x from EliteClub x WHERE lower(x.clubName) LIKE :searchTerm order by x.clubName as c")
	List<EliteClub> findClubs(@Param("search Term") String searchTerm);
}
