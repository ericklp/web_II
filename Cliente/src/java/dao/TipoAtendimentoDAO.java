/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.TipoAtendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ericklopes
 */
public class TipoAtendimentoDAO {
    private final Connection conn;

    public TipoAtendimentoDAO() throws SQLException, ClassNotFoundException {
        this.conn = (Connection) new ConnectionFactory().getConnection();
    }

    public List<TipoAtendimento> getTipoAtendimento() throws SQLException {
        ResultSet rs;
        List<TipoAtendimento> tipos = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String query = "select * from tb_tipo_atendimento";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id_tipo_atendimento");
            String nome = rs.getString("nome_tipo_atendimento");
            TipoAtendimento tipo = new TipoAtendimento();
            tipo.setId(id);
            tipo.setNome(nome);
            tipos.add(tipo);
        }
        return tipos;
    }

    public TipoAtendimento getTipoAtendimentoById(int idTipoAtendimento) throws SQLException {
        String sql = "SELECT * FROM tb_tipo_atendimento e WHERE id_tipo_atendimento=(?);";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idTipoAtendimento);

        ResultSet res = stmt.executeQuery();

        while (res.next()) {
            int id = res.getInt("id_tipo_atendimento");
            String nome = res.getString("nome_tipo_atendimento");
            TipoAtendimento tipo = new TipoAtendimento();
            tipo.setId(id);
            tipo.setNome(nome);
            return tipo;
        }
        return null;
    }
}