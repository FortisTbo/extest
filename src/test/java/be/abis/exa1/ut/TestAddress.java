package be.abis.exa1.ut;

import be.abis.exa1.model.Address;
import be.abis.exa1.model.Person;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

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

    @Test
    public void addressShouldBeAppendInAFile ()  {
        // arrange
        String fileName = "addressInfo.txt";

        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgian","01");
        a.appendInFile(fileName);

        Address a1 = new Address("rue tabaga","32 bus 4B","3000","Leuven","Belgian","01");
        a1.appendInFile(fileName);


        String allLine = readInFile(fileName);
        System.out.println(allLine);


        assertThat(allLine,containsString("Address{street='"+a1.getStreet()));

    }



    public String readInFile (String fileName){
        String allLine = "";
        String nextLine;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName));){
            while ((nextLine = br.readLine()) != null) {
                allLine +=nextLine;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return allLine;
    }
}
