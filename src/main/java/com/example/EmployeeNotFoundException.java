package com.example;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int id) {
        super("Impiegato non trovato per l'id " + id);
    }


}
