package com.billchange.coins.exception;

/* Created by RG on 12/19/21 */
public class InvalidBillException extends Exception {
    Integer bill;

    public InvalidBillException(Integer billAmount) {
        bill = billAmount;
    }

    @Override
    public String toString() {
        return "InvalidBillException." +
                "Bill amount entered " + bill +
                " is not a valid bill. \nBills allowed are 1,2,5,10,20,50,100";
    }
}
