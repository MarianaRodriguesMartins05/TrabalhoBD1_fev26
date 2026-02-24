/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mycompany.condominio.model.*;

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
    
    public static ArrayList<AvisoModel> listarAvisos() {

        ArrayList<AvisoModel> lista = new ArrayList<>();

        String sql = "SELECT a.titulo, a.mensagem, a.data_publicacao, s.nome FROM aviso a " +
        "INNER JOIN sindico s ON a.id_sindico = s.id_sindico ORDER BY a.data_publicacao DESC";

        try {
            Connection con = Conexao.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AvisoModel aviso = new AvisoModel(
                    rs.getString("titulo"),
                    rs.getString("mensagem"),
                    rs.getDate("data_publicacao"),
                    rs.getString("nome")
                );

                lista.add(aviso);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
}
