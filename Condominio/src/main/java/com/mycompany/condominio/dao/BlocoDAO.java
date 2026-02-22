/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;
import java.sql.*;

/**
 *
 * @author marih
 */
public class BlocoDAO {
    public static String blocoUsuario (int idBloco) {
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT nome_bloco FROM bloco where id_bloco=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBloco);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                return resultado.getString("nome_bloco");
            } else {
                return null; // não encontrou registro
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
}
