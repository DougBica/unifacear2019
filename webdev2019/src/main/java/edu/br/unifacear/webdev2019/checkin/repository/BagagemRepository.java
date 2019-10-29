package edu.br.unifacear.webdev2019.checkin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.br.unifacear.webdev2019.checkin.entity.Bagagem;

public interface BagagemRepository extends JpaRepository<Bagagem, Long> {
	
	@Query("select b from Bagagem b where b.guidCheckin = ? ")
	List<Bagagem> findByGuidCheckin(Long id);

}
