package com.billchange.coins.service;

import com.billchange.coins.domain.Coins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.logging.Logger;

/* Created by RG on 12/19/21 */
@Service
public class CoinsService {
    @Autowired
    Coins coins;
    Logger logger = Logger.getLogger(CoinsService.class.getName());

    public String calculateChange(Integer bill) {
        logger.info("Calculating the change for the bill:" + bill + "coins:" + coins.getTotalDimes());
        BigDecimal totalleft = new BigDecimal(bill);
        logger.info("totalleft:" + totalleft);
        Integer NoOfQuarters = 0;
        Integer NoOfDimes = 0;
        Integer NoOfCents = 0;
        Integer NoOfNickels = 0;
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");
        BigDecimal cent = new BigDecimal("0.01");
        while (coins.getTotalQuarters() > 0) {
            if (totalleft.subtract(quarter).compareTo(BigDecimal.ZERO) >= 0) {
                totalleft = totalleft.subtract(quarter);
                NoOfQuarters = NoOfQuarters + 1;
                coins.setTotalQuarters(coins.getTotalQuarters() - 1);
                logger.info("totalleft:" + totalleft + "NoOfQuarters:" + NoOfQuarters);
            } else {
                break;
            }
        }
        while (coins.getTotalDimes() > 0) {
            if (totalleft.subtract(dime).compareTo(BigDecimal.ZERO) >= 0) {
                totalleft = totalleft.subtract(dime);
                NoOfDimes = NoOfDimes + 1;
                coins.setTotalDimes(coins.getTotalDimes() - 1);
                logger.info("totalleft:" + totalleft + "NoOfDimes:" + NoOfDimes);
            } else {
                break;
            }
        }
        while (coins.getTotalNickels() > 0) {
            if (totalleft.subtract(nickel).compareTo(BigDecimal.ZERO) >= 0) {
                totalleft = totalleft.subtract(nickel);
                NoOfNickels = NoOfNickels + 1;
                coins.setTotalNickels(coins.getTotalNickels() - 1);
                logger.info("totalleft:" + totalleft + "NoOfNickels:" + NoOfNickels);
            } else {
                break;
            }
        }
        while (coins.getTotalCents() > 0) {
            if (totalleft.subtract(cent).compareTo(BigDecimal.ZERO) >= 0) {
                totalleft = totalleft.subtract(cent);
                NoOfCents = NoOfCents + 1;
                coins.setTotalCents(coins.getTotalCents() - 1);
                logger.info("totalleft:" + totalleft + "NoOfCents:" + NoOfCents);
            } else {
                break;
            }
        }
        if (totalleft.equals(new BigDecimal("0.00"))) {
            return "NoOfQuarters:" + NoOfQuarters + "\nNoOfDimes: " + NoOfDimes + "\nNoOfNickels: " + NoOfNickels + "\nNoOfCents:" + NoOfCents;
        } else {
            return "NoOfQuarters:" + NoOfQuarters + "\nNoOfDimes: " + NoOfDimes + "\nNoOfNickels: " + NoOfNickels + "\nNoOfCents:" + NoOfCents + "There are not enough coins to make the change.Total Left:f" + totalleft;
        }
    }
}
