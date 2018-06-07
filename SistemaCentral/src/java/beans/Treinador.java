/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author ericklopes
 */
import java.io.Serializable;
public class Treinador implements Serializable {
    
    private int id;
    private String login;
    private String nome;
    private String senha;
    private int id_preferido;

    public Treinador() {
        
    }

    public int getId_preferido() {
        return id_preferido;
    }

    public void setId_preferido(int id_preferido) {
        this.id_preferido = id_preferido;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
