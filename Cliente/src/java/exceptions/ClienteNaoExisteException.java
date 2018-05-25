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
public class ClienteNaoExisteException extends AppException {

    /**
     * Creates a new instance of <code>ClienteNaoExisteException</code> without
     * detail message.
     */
    public ClienteNaoExisteException() {
    }

    /**
     * Constructs an instance of <code>ClienteNaoExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ClienteNaoExisteException(String msg) {
        super(msg);
    }
}
