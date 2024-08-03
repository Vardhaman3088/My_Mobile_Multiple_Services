package com.gl.HitachiMobileSimService.repository;

import com.gl.HitachiMobileSimService.entity.SimOffers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimOffersRepository extends JpaRepository<SimOffers, Integer> {

    List<SimOffers> findAllBySimDetails_SimId(int simId);

}
