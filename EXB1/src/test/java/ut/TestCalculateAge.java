package ut;

import exb1.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCalculateAge {

    @Test
    public void ageOfPersonFromBirthDateShouldBe42 () throws Exception {
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1978, 6, 28));

        Integer result = p1.calculateAge();

        assertThat(result,is(equalTo(42)));
    }
}
