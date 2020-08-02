package com.petz.exceptions;

public class PetNotFound extends RuntimeException {
    public PetNotFound(String s) {
        super(s);
    }
}
