package com.company.exception;

public class AppException extends Exception {

	/**
     * 
     */
    private static final long serialVersionUID = -3827278770349863965L;

    public AppException() {
        super();
    }

    /**
     * @param strMsg
     */
    public AppException(String strMsg) {
        super(strMsg);
    }

}
