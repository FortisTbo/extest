package exb1.exception;

public class SalaryTooLowException extends Exception {
    public SalaryTooLowException() {
    }

    public SalaryTooLowException(String message) {
        super(message);
    }
}
