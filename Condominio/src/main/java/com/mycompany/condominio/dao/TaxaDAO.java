/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.mycompany.condominio.model.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.HashSet;


/**
 *
 * @author Mariana
 */
public class TaxaDAO {
    public static String criarTaxa(Float valorTaxa,  Date dataVencimento, String descricaoTaxa, Integer unidade, String status) {
        try {
            Integer idUnidade = UnidadeDAO.buscarIdUnidade(unidade);
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
    
    public List<TaxaModel> listarTaxas(Integer idUnidade) {

        List<TaxaModel> lista = new ArrayList<>();

        String sql =
            "SELECT t.id_taxa, t.valor, t.data_vencimento, t.descricao, u.id_unidade, u.num_unidade, s.id_status, s.status " +
            "FROM taxa t JOIN unidade u ON t.id_unidade = u.id_unidade JOIN status s ON t.id_status = s.id_status ";

        if (idUnidade != null) {
            sql += "WHERE t.id_unidade = ?";
        }

        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (idUnidade != null) {
                ps.setInt(1, idUnidade);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaxaModel taxa = new TaxaModel();
                taxa.setIdTaxa(rs.getInt("id_taxa"));
                taxa.setValor(rs.getFloat("valor"));
                taxa.setDataVencimento(rs.getDate("data_vencimento"));
                taxa.setDescricao(rs.getString("descricao"));
                taxa.setNumUnidade(rs.getInt("num_unidade"));
                taxa.setStatus(rs.getString("status"));
      

                lista.add(taxa);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public static boolean updateStatus(int idTaxa, String status) {
        String sql = "UPDATE taxa t JOIN status s ON s.status = ? SET t.id_status = s.id_status WHERE t.id_taxa = ?;";

        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(2, idTaxa);
            ps.setString(1, status);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (   Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
