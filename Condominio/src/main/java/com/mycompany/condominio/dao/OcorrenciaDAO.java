/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.mycompany.condominio.model.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Mariana
 */
public class OcorrenciaDAO {
    public static String cadastrarOcorrencia(String descricao, Date data, Integer unidade) {
        try {
            Integer idUnidade = UnidadeDAO.buscarIdUnidade(unidade);
            
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO ocorrencia (descricao, data_ocorrencia, id_unidade) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, descricao);
            ps.setDate(2, data);
            ps.setInt(3, idUnidade);

            ps.executeUpdate();

            return "Ocorrência criada com sucesso!";
        } catch (Exception e) {
            return "Erro ao criar a ocorrência: " + e.getMessage();
        }
    }
    
    public List<OcorrenciaModel> buscarOcorrencias(Integer idUnidade) {

        List<OcorrenciaModel> lista = new ArrayList<>();

        String sql =
            "SELECT o.id_ocorrencia, o.data_ocorrencia, o.descricao, u.num_unidade " +
            "FROM ocorrencia o " +
            "JOIN unidade u ON u.id_unidade = o.id_unidade ";

        if (idUnidade != null) {
            sql += "WHERE o.id_unidade = ?";
        }
        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (idUnidade != null) {
                ps.setInt(1, idUnidade);
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OcorrenciaModel o = new OcorrenciaModel();
                o.setIdOcorrencia(rs.getInt("id_ocorrencia"));
                o.setDataOcorrencia(rs.getDate("data_ocorrencia"));
                o.setDescricao(rs.getString("descricao"));
                o.setNumUnidade(rs.getInt("num_unidade"));

                lista.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
}
