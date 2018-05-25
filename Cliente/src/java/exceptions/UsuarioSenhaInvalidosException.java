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
public class UsuarioSenhaInvalidosException extends AppException {

    /**
     * Creates a new instance of <code>UsuarioSenhaInvalidosException</code>
     * without detail message.
     */
    public UsuarioSenhaInvalidosException() {
    }

    /**
     * Constructs an instance of <code>UsuarioSenhaInvalidosException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UsuarioSenhaInvalidosException(String msg) {
        super(msg);
    }
}
