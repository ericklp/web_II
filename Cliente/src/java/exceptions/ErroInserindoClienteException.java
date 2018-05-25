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
public class ErroInserindoClienteException extends AppException {

    /**
     * Creates a new instance of <code>ErroInserindoClienteException</code>
     * without detail message.
     */
    public ErroInserindoClienteException() {
    }

    /**
     * Constructs an instance of <code>ErroInserindoClienteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ErroInserindoClienteException(String msg) {
        super(msg);
    }
}
