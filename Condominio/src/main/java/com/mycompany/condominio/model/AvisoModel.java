/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.model;

import java.sql.Date;

/**
 *
 * @author Mariana
 */
public class AvisoModel {
    private String titulo;
    private String mensagem;
    private Date data;
    private String sindico;

    public AvisoModel() {
    }

    public AvisoModel(String titulo, String mensagem, Date data, String sindico) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.data = data;
        this.sindico = sindico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSindico() {
        return sindico;
    }

    public void setSindico(String sindico) {
        this.sindico = sindico;
    }
    
}
