package com.company.exception;

/**
 * @author akumar
 *
 */
public class AppException extends Exception {

    private static final long serialVersionUID = -3827278770349863965L;

    public AppException() {
        super();
    }

    /**
     * @param strMsg
     */
    public AppException(final String strMsg) {
        super(strMsg);
    }
}
