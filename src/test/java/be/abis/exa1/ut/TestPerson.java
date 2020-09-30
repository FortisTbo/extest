package be.abis.exa1.ut;

import be.abis.exa1.model.Person;
import org.junit.Assert;
import org.junit.Test;


import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TestPerson {

    @Test
    public void ageOfPersonFromBirthDateShouldBe42 () {
        Integer expected = 42;
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1978, 6, 28));

        Integer result = p1.calculateAge();
        assertEquals (expected, result);
    }

    @Test
    public void toStringSentenceStartsWithPerson () {

        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1978, 6, 28));
        String p1ToString = p1.toString();

        assertThat(p1ToString,startsWith("Person"));

    }
}
