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
    
}
