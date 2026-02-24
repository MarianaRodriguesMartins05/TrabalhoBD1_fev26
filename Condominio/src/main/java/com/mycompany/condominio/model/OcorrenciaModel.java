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
public class OcorrenciaModel {

    private int idOcorrencia;
    private Date dataOcorrencia;
    private String descricao;
    private int idUnidade;  
    private int numUnidade;

    public OcorrenciaModel() {
    }
    
    public OcorrenciaModel(int idOcorrencia, Date dataOcorrencia, String descricao, int idUnidade, int numUnidade) {
        this.idOcorrencia = idOcorrencia;
        this.dataOcorrencia = dataOcorrencia;
        this.descricao = descricao;
        this.idUnidade = idUnidade;
        this.numUnidade = numUnidade;
    }

    public int getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(int idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }
    

    public int getNumUnidade() {
        return numUnidade;
    }

    public void setNumUnidade(int numUnidade) {
        this.numUnidade = numUnidade;
    }
}
