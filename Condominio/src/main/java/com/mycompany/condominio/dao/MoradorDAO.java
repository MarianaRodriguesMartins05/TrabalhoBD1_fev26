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
import com.mycompany.condominio.model.*;

/**
 *
 * @author Mariana
 */
public class MoradorDAO {
    
    public static String cadastrarMorador(String nome, String cpf, String telefone, String email, Integer unidade) {
        try {
            Integer idUnidade = UnidadeDAO.buscarIdUnidade(unidade);
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
    
    
    public static String buscarCpfNomeAndUnidade (String nome, Integer unidade) {
        
        String cpf = null;
        
        try {
            Integer idUnidade = UnidadeDAO.buscarIdUnidade(unidade);
                        
            String sql = "SELECT cpf FROM morador WHERE id_unidade = ? and nome = ?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idUnidade);
            ps.setString(2, nome);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                cpf = rs.getString("cpf");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cpf;
    }
    
    

    
   
    public static boolean deletarMorador(String nome, Integer unidade) {

        try {
            String cpf = buscarCpfNomeAndUnidade(nome, unidade);
            String sql = "DELETE FROM morador WHERE cpf = ? ";
            
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.executeUpdate();
            
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<String> listarPorUnidade(Integer unidade) {
        
        List<String> lista = new ArrayList<>();

        try {
            Integer idUnidade = UnidadeDAO.buscarIdUnidade(unidade);
            
            String sql = "SELECT nome FROM morador WHERE id_unidade = ?";
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idUnidade);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                String nome = rs.getString("nome");
                
                lista.add(nome);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public List<MoradorModel> listarPorNome(String nome) {

        List<MoradorModel> lista = new ArrayList<>();

        String sql =
            "SELECT m.cpf, m.nome, m.telefone, m.email, u.num_unidade FROM morador m " +
            "JOIN unidade u ON u.id_unidade = m.id_unidade WHERE m.nome LIKE ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (nome == null || nome.trim().isEmpty()) {
                ps.setString(1, "%");
            } else {
                ps.setString(1, "%" + nome + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MoradorModel m = new MoradorModel();
                m.setCpf(rs.getString("cpf"));
                m.setNome(rs.getString("nome"));
                m.setTelefone(rs.getString("telefone"));
                m.setEmail(rs.getString("email"));
                m.setNumUnidade(rs.getInt("num_unidade")); 

                lista.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
}
    

