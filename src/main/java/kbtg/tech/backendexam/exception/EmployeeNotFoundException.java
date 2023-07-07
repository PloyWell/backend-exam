package kbtg.tech.backendexam.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException( String message )
    {
        super( message );
    }
}
