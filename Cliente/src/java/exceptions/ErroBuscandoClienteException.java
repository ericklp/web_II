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
public class ErroBuscandoClienteException extends AppException {

    /**
     * Creates a new instance of <code>ErroBuscandoClienteException</code>
     * without detail message.
     */
    public ErroBuscandoClienteException() {
    }

    /**
     * Constructs an instance of <code>ErroBuscandoClienteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ErroBuscandoClienteException(String msg) {
        super(msg);
    }
}
