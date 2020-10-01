package ut;

import exb1.model.Address;
import exb1.model.Company;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCompany {

    Company c;
    @Before
    public void setUp(){
        Address a = new Address ("Diestsevest","32 bus 4B","3000","Leuven","Belgium","BE");
        c = new Company("VK1" , a);
    }

    @Test
    public void taxForBelgianCompanyShouldBe51 () {
        // arrange
        Double  expected = 51.0;

        // act
        Double result = c.calculateTaxToPay();

        // assert
        assertEquals (expected, result);
    }
}
