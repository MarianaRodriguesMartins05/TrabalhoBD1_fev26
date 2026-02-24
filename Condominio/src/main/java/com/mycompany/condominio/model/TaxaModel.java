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
public class TaxaModel {
    private int idTaxa;
    private float valor;
    private Date dataVencimento;
    private String descricao;
    private int numUnidade;
    private String status;

    public TaxaModel() {
    }

    public TaxaModel(int idTaxa, float valor, Date dataVencimento, String descricao, int numUnidade, String status) {
        this.idTaxa = idTaxa;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.descricao = descricao;
        this.numUnidade = numUnidade;
        this.status = status;
    }

    public int getIdTaxa() {
        return idTaxa;
    }

    public void setIdTaxa(int idTaxa) {
        this.idTaxa = idTaxa;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumUnidade() {
        return numUnidade;
    }

    public void setNumUnidade(int numUnidade) {
        this.numUnidade = numUnidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

    