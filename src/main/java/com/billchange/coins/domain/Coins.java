package com.billchange.coins.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/* Created by RG on 12/19/21 */

@Component
@Getter
@Setter
public class Coins {
    @Value("${coins.total.ones}")
    Integer totalCents;
    @Value("${coins.total.nickels}")
    Integer totalNickels;
    @Value("${coins.total.dimes}")
    Integer totalDimes;
    @Value("${coins.total.quarters}")
    Integer totalQuarters;


}
