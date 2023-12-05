package com.napptilus.sppr.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class InvalidRequestParameterException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7674559836231766974L;

    private final String name;

    private final String value;

    public InvalidRequestParameterException(final String name, final String value, final String message) {
        super(message);

        this.name = name;
        this.value = value;
    }

}
