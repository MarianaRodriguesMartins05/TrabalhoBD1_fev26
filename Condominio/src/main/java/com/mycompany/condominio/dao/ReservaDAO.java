/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.mycompany.condominio.model.*;

/**
 *
 * @author Mariana
 */
public class ReservaDAO {
    public static String criarReserva(Time hrInicio, Time hrFim, Date dataReserva, String cpf, String area) {
        try {
            Integer idArea = AreaComumDAO.bucarIdArea(area); //.bucarIdUnidade(unidade); //musar pra buscr id Area
            
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO reserva (data_reserva, horario_inicio, horario_fim, cpf_morador, id_area) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, dataReserva);
            ps.setTime(2, hrInicio);
            ps.setTime(3, hrFim);
            ps.setString(4, cpf);
            ps.setInt(5, idArea);

            ps.executeUpdate();

            return "Reserva criada com sucesso!";
        } catch (Exception e) {
            return "Erro ao criar a Reserva: " + e.getMessage();
        }
    }
    
    
    public List<ReservaModel> buscarReservas(String area) {

        List<ReservaModel> lista = new ArrayList<>();

        String sql = "SELECT r.id_reserva, r.data_reserva, r.horario_inicio, r.horario_fim, r.cpf_morador, a.nome_area " +
        "FROM reserva r JOIN area_comum a ON a.id_area = r.id_area ";

        if (area != null && !area.isEmpty()) {
            sql += "WHERE a.nome_area = ?";
        }

        sql += " ORDER BY r.id_reserva";

        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (area != null && !area.isEmpty()) {
                ps.setString(1, area);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ReservaModel r = new ReservaModel();
                r.setIdReserva(rs.getInt("id_reserva"));
                r.setDataReserva(rs.getDate("data_reserva"));
                r.setHorarioInicio(rs.getTime("horario_inicio"));
                r.setHorarioFim(rs.getTime("horario_fim"));
                r.setCpfMorador(rs.getString("cpf_morador"));
                r.setArea(rs.getString("nome_area"));

                lista.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
    

