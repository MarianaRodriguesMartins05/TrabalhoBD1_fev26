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
public class UnidadeDAO {
    public static List<Integer> unidadeBloco (int idBloco) {
        List<Integer> unidades = new ArrayList<>();     
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT num_unidade FROM unidade where id_bloco=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBloco);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                unidades.add(rs.getInt("num_unidade"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidades;
    }
    
    public static Integer bucarIdUnidade (int numUnidade) {
        Integer resultNumUnidade = null;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT id_unidade FROM unidade where num_unidade=? and id_bloco=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numUnidade);
            ps.setInt(2, Parametro.getInstance().getIdBloco());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultNumUnidade = rs.getInt("id_unidade");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultNumUnidade;
    }
    
    
    
}
