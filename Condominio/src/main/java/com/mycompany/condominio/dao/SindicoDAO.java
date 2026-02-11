/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author marih
 */
public class SindicoDAO {
    public static ResultSet autenticar(String usuario, String senha) {
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT id_sindico, id_bloco FROM sindico WHERE usuario=? AND senha=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            System.out.println(ps.executeQuery());
            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
