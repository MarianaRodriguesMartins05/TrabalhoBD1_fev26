/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.model;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Mariana
 */
public class ReservaModel {
    private int idReserva;
    private Date dataReserva;
    private Time horarioInicio;
    private Time horarioFim;
    private String cpfMorador;
    private String area;

    public ReservaModel() {
    }

    public ReservaModel(int idReserva, Date dataReserva, Time horarioInicio, Time horarioFim, String cpfMorador, String area) {
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.cpfMorador = cpfMorador;
        this.area = area;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Time horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getCpfMorador() {
        return cpfMorador;
    }

    public void setCpfMorador(String cpfMorador) {
        this.cpfMorador = cpfMorador;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    
}
