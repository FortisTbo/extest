package ut;

import exb1.exception.MinorException;
import exb1.model.Address;
import exb1.model.Company;
import exb1.model.Person;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;


@DisplayName("Test on the person")
@RunWith(MockitoJUnitRunner.class)
public class TestPerson {
    @Mock
    Person p1;

    @Before
    public void setUp() {

        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgi�","BE");
        Company c = new Company("ABIS",a);
        p1 = new Person(1,"Ann","Smits", LocalDate.of(1978, 6, 28), 4500.0, c);

    }

    @Test
    @DisplayName("Age of Person should be 42")
    public void ageOfPersonFromBirthDateShouldBe42 () throws Exception {
        Integer expected = 42;

        Integer result = p1.calculateAge();
        assertEquals (expected, result);
    }

    @Test
    @DisplayName("sentence should should start with 'Person'")
    public void toStringSentenceStartsWithPerson () {

        String p1ToString = p1.toString();

        assertThat(p1ToString,startsWith("Person"));

    }

    @Test(expected= MinorException.class)
    @DisplayName("person should be an adult")
    public void personShouldBeAdultException () throws Exception {
        p1.setBirthDay(LocalDate.of(2010, 6, 28));

        Integer result = p1.calculateAge();



    }

    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany() {
        when(p1.calculateNetSalary()).thenReturn(2000.0);

        //Double expected = 2205.0;
        Double result = p1.calculateNetSalary();

        //assertEquals (expected, result);


        verify(p1).calculateNetSalary();

    }
}
