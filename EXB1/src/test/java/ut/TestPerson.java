package ut;

import exb1.exception.MinorException;
import exb1.model.Person;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Test on the person")
public class TestPerson {
    private  Person p1;

    @Before
    public void setUp() {
        p1 = new Person(1,"Ann","Smits", LocalDate.of(1978, 6, 28));

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
}
