package exb1.model;

import exb1.exception.SalaryTooLowException;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;
}
