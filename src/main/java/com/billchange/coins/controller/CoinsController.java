package com.billchange.coins.controller;


import com.billchange.coins.exception.InvalidBillException;
import com.billchange.coins.service.CoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/* Created by RG on 12/19/21 */
@RestController
public class CoinsController {
    @Autowired
    public CoinsService coinsService;

    @GetMapping(value = "getChangeForBill/{bill}")
    public ResponseEntity<String> getChangeForBill(@PathVariable Integer bill) {
        {
            try {
                if (!isValidBillAmount(bill)) {
                    throw new InvalidBillException(bill);
                } else {

                    return new ResponseEntity<>(coinsService.calculateChange(bill), HttpStatus.OK);

                }

            } catch (InvalidBillException e) {
                return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

            }

        }
    }

    public boolean isValidBillAmount(Integer bill) {
        Integer bills[] = {1, 2, 5, 10, 20, 50, 100};
        if (Arrays.asList(bills).contains(bill)) {
            return true;
        } else {
            return false;
        }
    }
}
