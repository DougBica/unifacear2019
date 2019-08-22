package edu.br.unifacear.webdev2019.checkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.checkin.entity.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Long>{

}
