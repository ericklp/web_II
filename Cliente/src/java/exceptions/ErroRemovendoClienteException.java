/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author ericklopes
 */
public class ErroRemovendoClienteException extends AppException {

    /**
     * Creates a new instance of <code>ErroRemovendoClienteException</code>
     * without detail message.
     */
    public ErroRemovendoClienteException() {
    }

    /**
     * Constructs an instance of <code>ErroRemovendoClienteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ErroRemovendoClienteException(String msg) {
        super(msg);
    }
}
