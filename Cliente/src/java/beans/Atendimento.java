/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ericklopes
 */
public class Atendimento implements Serializable {
    private int id;
    private  java.util.Date data;
    private String descricao;
    private Produto produto;
    private TipoAtendimento tipo_atendimento;
    private Usuario usuario;
    private String res_atendimento;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Atendimento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.util.Date getData() {
        return data;
    }

    public void setData( java.util.Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoAtendimento getTipo_atendimento() {
        return tipo_atendimento;
    }

    public void setTipo_atendimento(TipoAtendimento tipo_atendimento) {
        this.tipo_atendimento = tipo_atendimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRes_atendimento() {
        return res_atendimento;
    }

    public void setRes_atendimento(String res_atendimento) {
        this.res_atendimento = res_atendimento;
    }
    
}
