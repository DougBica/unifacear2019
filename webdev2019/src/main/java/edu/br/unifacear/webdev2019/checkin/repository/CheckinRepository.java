package edu.br.unifacear.webdev2019.checkin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.br.unifacear.webdev2019.checkin.entity.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Long>{

	@Query("select c from Checkin c where c.token = ?1")
	Checkin findByToken(String id);

	@Query("select c from Checkin c where c.guidStatus = 1")
	List<Checkin> findByStatus();
	
}
