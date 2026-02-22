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
public class AreaComumDAO {
    public static List<String> nomeAreas () {
        List<String> nomeArea = new ArrayList<>();     
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT nome_area FROM area_comum";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nomeArea.add(rs.getString("nome_area"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nomeArea;
    }
    
}
