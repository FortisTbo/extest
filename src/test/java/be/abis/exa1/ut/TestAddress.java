package be.abis.exa1.ut;

import be.abis.exa1.model.Address;
import be.abis.exa1.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestAddress {

    @Test
    public void belgianZipCodeShouldBeNumeric () {

        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgian","BE");

        Integer expected = 42;
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1978, 6, 28));

        Integer result = p1.calculateAge();
        assertEquals (expected, result);
    }
}
