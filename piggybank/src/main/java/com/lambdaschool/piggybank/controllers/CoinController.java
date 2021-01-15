package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    CoinRepository coinrepos;

    double sum = 0;


    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<?> listTotal(){
        List<Coin> coinList = new ArrayList<>();
        List<Double> totalList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining((coinList::add));
        coinList.forEach((c) -> totalList.add(c.getQuantity() * c.getValue()));
        totalList.forEach((d) -> sum += d);
        System.out.println(coinList + " The piggy bank holds " + sum);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    //empty commits
}
