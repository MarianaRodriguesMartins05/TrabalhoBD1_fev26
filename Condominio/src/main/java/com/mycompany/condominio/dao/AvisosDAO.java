/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariana
 */
public class AvisosDAO {
    public static String cadastrarAviso(String titulo, String mensagem, Date dataPublicacao) {
        try {
            Integer idSindico = Parametro.getInstance().getIdSindico();
            
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO aviso (titulo, mensagem, data_publicacao, id_sindico) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, titulo);
            ps.setString(2, mensagem);
            ps.setDate(3, dataPublicacao);
            ps.setInt(4, idSindico);

            ps.executeUpdate();

            return "Aviso criado com sucesso!";
        } catch (Exception e) {
            return "Erro ao criar aviso: " + e.getMessage();
        }
    }
    
}
