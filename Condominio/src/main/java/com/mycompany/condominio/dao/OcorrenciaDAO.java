/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Mariana
 */
public class OcorrenciaDAO {
    public static String cadastrarOcorrencia(String descricao, Date data, Integer unidade) {
        try {
            Integer idUnidade = UnidadeDAO.bucarIdUnidade(unidade);
            
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
}
