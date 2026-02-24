/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

/**
 *
 * @author Mariana
 */
public class TaxaDAO {
    public static String criarTaxa(Float valorTaxa,  Date dataVencimento, String descricaoTaxa, Integer unidade, String status) {
        try {
            Integer idUnidade = UnidadeDAO.bucarIdUnidade(unidade);
            Integer idStatus = StatusDAO.bucarIdStatus(status);
            
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO taxa (valor, data_vencimento, id_unidade, descricao, id_status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setFloat(1, valorTaxa);
            ps.setDate(2, dataVencimento);
            ps.setInt(3, idUnidade);
            ps.setString(4, descricaoTaxa);
            ps.setInt(5, idStatus);
            
            ps.executeUpdate();

            return "Taxa criada com sucesso!";
        } catch (Exception e) {
            return "Erro ao criar a Taxa: " + e.getMessage();
        }
    }
    
}
