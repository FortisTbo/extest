package ut;

import exb1.model.Address;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestAddress {

    Address a;
    @Before
    public void setUp(){
        a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgium","01");
    }

    @Test
    public void belgianZipCodeShouldBeNumeric () {
        // arrange
        boolean expected = true;

        // act
        boolean result = a.checkBelgianZipCoded();

        // assert
        assertEquals (expected, result);
    }

    @Test
    public void appendingAddressToFileShouldReturnExtraLineInFile() throws IOException {
        Path path = Address.getFilePath();
        int countBeforeWrite=0;
        if (Files.exists(path)) {
            path.toFile().setWritable(true);
            countBeforeWrite = Files.readAllLines(path).size();
        }
        a.writeToFile();
        int countAfterWrite = Files.readAllLines(path).size();
        int linesAdded=countAfterWrite - countBeforeWrite;
        assertEquals(1,linesAdded);
    }

    @Test(expected= IOException.class)
    public void appendingAddressToExistingReadOnlyFileShouldThrowIOException() throws IOException {
        Path path = Address.getFilePath();
        File file = path.toFile();
        if (!Files.exists(path)) {
            file.createNewFile();
        }
        file.setReadOnly();
        a.writeToFile();
    }

    @Ignore
    @Test
    public void noIdeaYetWhatWeAreGoingToTest() {

    }
}
