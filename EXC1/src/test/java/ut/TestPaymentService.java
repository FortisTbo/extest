package ut;

import exb1.exception.SalaryTooLowException;
import exb1.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    PaymentService paymentService;

    @Mock
    Person pMock;

    @Before
    public void setUp() {
        paymentService = new AbisPaymentService();
    }

    @Test
    public void shouldPrintMessage() throws SalaryTooLowException {
        when(pMock.calculateNetSalary()).thenReturn(15000.0);
        when(pMock.getFirstName()).thenReturn("John1");

        paymentService.paySalary(pMock);
    }

    @Test(expected= SalaryTooLowException.class)
    public void shouldHaveASalaryTooLowException() throws SalaryTooLowException {
        when(pMock.calculateNetSalary()).thenThrow(SalaryTooLowException.class);

        paymentService.paySalary(pMock);
    }
}
