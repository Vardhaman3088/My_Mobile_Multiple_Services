package com.gl.MyMobileCustomerService.client;

import com.gl.MyMobileCustomerService.dto.SimDetails;
import com.gl.MyMobileCustomerService.dto.SimOffers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MyMobileSimService")
public interface SimClient {
    @GetMapping("/ShowOffer/{simId}")
    public ResponseEntity<String> ShowOfferWithId(@PathVariable Integer simId);

    @GetMapping("/simDetails/{simId}")
    public ResponseEntity<SimDetails> ShowDetailsWithId(@PathVariable Integer simId);

    @GetMapping("/simOffer/{simId}")
    public ResponseEntity<SimOffers> ShowOfferObjectWithId(@PathVariable Integer simId);
}
