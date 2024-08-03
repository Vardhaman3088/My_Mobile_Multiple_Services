package com.gl.HitachiMobileSimService.service;

import com.gl.HitachiMobileSimService.dto.SIMValidationDto;
import com.gl.HitachiMobileSimService.entity.SimDetails;
import com.gl.HitachiMobileSimService.entity.SimOffers;

public interface SimService {
    String validateSIM(SIMValidationDto simValidationDto);

    SimOffers ShowOfferWithId(Integer simId);

    String updateStatus(Integer simid);

    SimDetails showSimDetailsById(Integer simId);

    SimOffers ShowOfferObjectWithId(Integer simId);
}
