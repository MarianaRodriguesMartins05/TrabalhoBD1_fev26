/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariana
 */
public class MoradorDAO {
    
    public static String cadastrarMorador(String nome, String cpf, String telefone, String email, Integer unidade) {
        try {
            Integer idUnidade = UnidadeDAO.bucarIdUnidade(unidade);
            System.out.println(idUnidade);
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO morador (nome, cpf, telefone, email, id_unidade) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, telefone);
            ps.setString(4, email);
            ps.setInt(5, idUnidade);

            ps.executeUpdate();

            ps.close();
            con.close();

            return "Morador cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar morador: " + e.getMessage();
        }
    }
    
    
}
