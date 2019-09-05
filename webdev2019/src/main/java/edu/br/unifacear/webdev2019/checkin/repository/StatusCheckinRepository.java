package edu.br.unifacear.webdev2019.checkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.checkin.entity.StatusCheckin;

public interface StatusCheckinRepository extends JpaRepository<StatusCheckin, Long> {

}
