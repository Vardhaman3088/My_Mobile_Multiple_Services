package com.gl.HitachiMobileSimService.controller;

import com.gl.HitachiMobileSimService.dto.SIMValidationDto;
import com.gl.HitachiMobileSimService.dto.SIMValidationDtoString;
import com.gl.HitachiMobileSimService.entity.SimDetails;
import com.gl.HitachiMobileSimService.entity.SimOffers;
import com.gl.HitachiMobileSimService.service.SimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class SimController {

    @Autowired
    SimService customerService;

    @PostMapping("/validateSIM")
    public ResponseEntity<String> validateSIM(@Valid @RequestBody SIMValidationDto simValidationDto) {
        return new ResponseEntity<>(customerService.validateSIM(simValidationDto), HttpStatus.OK);

    }


    @GetMapping("/ShowOffer/{simId}")
    public ResponseEntity<String> ShowOfferWithId(@PathVariable Integer simId){
//        System.out.println("heyyyyyyyyy"+simId);
        SimOffers simOffers = customerService.ShowOfferWithId(simId);
        System.out.println(simOffers);
        String ans = ""+simOffers.getDataQty()+"calls "+simOffers.getDataQty() +" Gb for Rs "+simOffers.getCost() + " validity: "+simOffers.getDuration() +" days";
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/updateStatus/{simid}")
    public String updateStatus(@PathVariable Integer simid){
        String res = customerService.updateStatus(simid);

        return res;
    }

    @GetMapping("/simDetails/{simId}")
    public ResponseEntity<SimDetails> ShowDetailsWithId(@PathVariable Integer simId){
//        System.out.println("heyyyyyyyyy"+simId);
        SimDetails simDetails = customerService.showSimDetailsById(simId);
        System.out.println(simDetails);
//        String ans = ""+simOffers.getDataQty()+"calls "+simOffers.getDataQty() +" Gb for Rs "+simOffers.getCost() + " validity: "+simOffers.getDuration() +" days";
        return new ResponseEntity<>(simDetails, HttpStatus.OK);
    }


    @GetMapping("/simOffer/{simId}")
    public ResponseEntity<SimOffers> ShowOfferObjectWithId(@PathVariable Integer simId){
//        System.out.println("heyyyyyyyyy"+simId);
        SimOffers simOffers = customerService.ShowOfferObjectWithId(simId);
        System.out.println(simOffers);
//        String ans = ""+simOffers.getDataQty()+"calls "+simOffers.getDataQty() +" Gb for Rs "+simOffers.getCost() + " validity: "+simOffers.getDuration() +" days";
        return new ResponseEntity<>(simOffers, HttpStatus.OK);
    }






}
