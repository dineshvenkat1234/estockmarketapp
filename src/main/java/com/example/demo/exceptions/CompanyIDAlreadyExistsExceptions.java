package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Company ID already exists!")
public class CompanyIDAlreadyExistsExceptions extends Exception{

}
