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
public class StatusDAO {
    public static List<String> buscarStatus () {
        List<String> status = new ArrayList<>();     
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT status FROM status";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                status.add(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static Integer bucarIdStatus (String status) {
        Integer resultIdStatus = null;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT id_status FROM status where status=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultIdStatus = rs.getInt("id_status");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultIdStatus;
    }
    
}
