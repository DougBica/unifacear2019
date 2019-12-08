package edu.br.unifacear.webdev2019.checkin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.br.unifacear.webdev2019.checkin.entity.Embarque;

public interface EmbarqueRepository extends JpaRepository<Embarque, Long>{

	@Query("select e from Embarque e where e.guidCheckin = ?1")
	List<Embarque> findByCheckin(Long id);

}
