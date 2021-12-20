package com.billchange.coins.service;

import com.billchange.coins.domain.Coins;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/* Created by RG on 12/19/21 */
@ExtendWith(MockitoExtension.class)
public class CoinsServiceTest {
    @InjectMocks
    CoinsService coinsService;
    @Mock
    Coins coins;

    @BeforeTestMethod
    public void initMocks() {
        when(coins.getTotalQuarters()).thenReturn(4);
        when(coins.getTotalDimes()).thenReturn(2);
        when(coins.getTotalNickels()).thenReturn(1);
        when(coins.getTotalCents()).thenReturn(0);

    }

    @Test
    public void testCalculateChange() {
        initMocks();
        assertEquals("NoOfQuarters:4\n" +
                "NoOfDimes: 0\n" +
                "NoOfNickels: 0\n" +
                "NoOfCents:0", coinsService.calculateChange(1));
    }

}
