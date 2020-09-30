package be.abis.exa1.ut;

import be.abis.exa1.model.Address;
import be.abis.exa1.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestAddress {

    @Test
    public void belgianZipCodeShouldBeNumeric () {
        // arrange
        boolean expected = true;
        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgian","01");

        // act
        boolean result = a.checkBelgianZipCoded();

        // assert
        assertEquals (expected, result);
    }
}
