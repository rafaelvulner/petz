package com.petz.exceptions;

public class ClienteNotFound extends RuntimeException {
    public ClienteNotFound(String s) {
        super(s);
    }
}
