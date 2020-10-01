package exb1.model;

import exb1.exception.SalaryTooLowException;

public class AbisPaymentService implements PaymentService {


    public void paySalary(Person person) throws SalaryTooLowException {

        System.out.println("Paying " + person.calculateNetSalary() + " euro to " + person.getFirstName());


    }
}
