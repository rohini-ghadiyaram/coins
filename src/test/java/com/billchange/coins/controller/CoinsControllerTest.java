package com.billchange.coins.controller;

import com.billchange.coins.service.CoinsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/* Created by RG on 12/19/21 */
@ExtendWith(MockitoExtension.class)
public class CoinsControllerTest {
    @InjectMocks
    CoinsController coinsController;
    @Mock
    CoinsService coinsServiceMock;

    //Test for valid Bill Amount 10
    @Test
    public void testIsValidBillAmount() {
        assertEquals(true, coinsController.isValidBillAmount(10));

    }

    //Test for Invalid Bill Amount 23
    @Test
    public void testIsValidBillAmountFalse() {
        assertEquals(false, coinsController.isValidBillAmount(23));

    }

    @Test
    public void testGetChangeForBillBadRequest() {
        ResponseEntity<String> responseEntity = coinsController.getChangeForBill(23);
        assertEquals(responseEntity.getStatusCodeValue(), 400);
    }

    //Test for success status code
    @Test
    public void testGetChangeForBill() {
        when(coinsServiceMock.calculateChange(10)).thenReturn("success");

        ResponseEntity<String> responseEntity = coinsController.getChangeForBill(10);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }
}
