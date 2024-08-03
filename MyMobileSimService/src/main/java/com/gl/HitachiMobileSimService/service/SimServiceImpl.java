package com.gl.HitachiMobileSimService.service;

import com.gl.HitachiMobileSimService.dto.SIMValidationDto;
import com.gl.HitachiMobileSimService.entity.SimDetails;
import com.gl.HitachiMobileSimService.entity.SimOffers;
import com.gl.HitachiMobileSimService.exception.InvalidSimServiceNumber;
import com.gl.HitachiMobileSimService.repository.SimDetailsRepository;
import com.gl.HitachiMobileSimService.repository.SimOffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimServiceImpl implements SimService {

    @Autowired
    SimDetailsRepository simDetailsRepository;

    @Autowired
    SimOffersRepository simOffersRepository;

    @Override
    public String validateSIM(SIMValidationDto simValidationDto) {
        Optional<SimDetails> simDetails = simDetailsRepository.findByServiceNumberAndSimNumber(simValidationDto.getServiceNumber(), simValidationDto.getSimNumber());
        System.out.println(simValidationDto.getServiceNumber());
        System.out.println(simValidationDto.getSimNumber());
        System.out.println(simDetails.toString());
        if(simDetails.isPresent()){
            if(simDetails.get().getSimStatus().equalsIgnoreCase("active")){
                return "SIM aleady active";
            }else{
                simDetailsRepository.updateSimStatusBySimId(simDetails.get().getSimId());
                return "Valid Details Welcome";
            }
        }
        else{
            throw new InvalidSimServiceNumber("Enter the valid Sim Number and the service number");
        }
    }

    @Override
    public SimOffers ShowOfferWithId(Integer simID) {
        return simOffersRepository.findById(simID).get();
    }

    @Override
    public String updateStatus(Integer simid) {
        System.out.println("SimId" + simid);
        simDetailsRepository.updateSimStatusBySimId(simid);

        return "Status updated Successfully";


    }

    @Override
    public SimDetails showSimDetailsById(Integer simId) {
        return simDetailsRepository.findById(simId).get();
    }

    @Override
    public SimOffers ShowOfferObjectWithId(Integer simId){
        return simOffersRepository.findAllBySimDetails_SimId(simId).get(0);
    }
}
