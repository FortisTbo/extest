package ut;

import exb1.exception.MinorException;
import exb1.exception.SalaryTooLowException;
import exb1.model.Address;
import exb1.model.Company;
import exb1.model.Person;

import java.io.IOException;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;



@RunWith(MockitoJUnitRunner.class)
public class TestPerson {
    Person p;


    @Mock
    Company cMock;

    @Before
    public void setUp() {

        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgiam","NL");
        Company c = new Company("ABIS",a);

        p = new Person(1,"Ann","Smits", LocalDate.of(1978, 6, 28), 4500.0, c);

    }

    @Test
    public void ageOfPersonFromBirthDateShouldBe42 () throws Exception {
        Integer expected = 42;

        Integer result = p.calculateAge();
        assertEquals (expected, result);
    }

    @Test
    public void toStringSentenceStartsWithPerson () {

        String p1ToString = p.toString();

        assertThat(p1ToString,startsWith("Person"));

    }

    @Test(expected= MinorException.class)
    public void personShouldBeAdultException () throws Exception {
        p.setBirthDay(LocalDate.of(2010, 6, 28));

        Integer result = p.calculateAge();



    }

    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany() throws SalaryTooLowException {
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1978, 6, 28), 4500.0, cMock);

        when(cMock.calculateTaxToPay()).thenReturn(51.0);

        Double expected = 2205.0;
        Double result = p1.calculateNetSalary();

        assertEquals (expected, result);


        verify(cMock).calculateTaxToPay();

    }

    @Test(expected= SalaryTooLowException.class)
    public void calculateNetSalary () throws SalaryTooLowException {
        p.setGrossSalary(0.0);
        Double result = p.calculateNetSalary();
    }

}
