package be.abis.exa1.ut;

import be.abis.exa1.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TestCalculateAge {

    @Test
    public void ageOfPersonFromBirthDateShouldBe42 () throws Exception {
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1978, 6, 28));

        Integer result = p1.calculateAge();

        assertThat(result,is(equalTo(42)));
    }
}
