package ut;

import exb1.exception.SalaryTooLowException;
import exb1.model.AbisPaymentService;
import exb1.model.Company;
import exb1.model.PaymentService;
import exb1.model.Person;
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
    @Mock
    Person pMock;
    @Mock
    Company cMock;

    @Test
    public void shouldPrintMessage() throws SalaryTooLowException {
        when(pMock.getGrossSalary()).thenReturn(1500.0);
        when(pMock.getFirstName()).thenReturn("John");

        when(cMock.calculateTaxToPay()).thenReturn(51.0);

        PaymentService paymentService = new AbisPaymentService();
        paymentService.paySalary(pMock);
    }

    @Test(expected= SalaryTooLowException.class)
    public void shouldHaveASalaryTooLowException() throws SalaryTooLowException {
        when(pMock.getGrossSalary()).thenReturn(0.0);
        when(pMock.getFirstName()).thenReturn("John");

        when(cMock.calculateTaxToPay()).thenReturn(51.0);

        PaymentService paymentService = new AbisPaymentService();
        paymentService.paySalary(pMock);
    }
}
