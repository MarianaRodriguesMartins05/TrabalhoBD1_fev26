/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.dao;

/**
 *
 * @author marih
 */
public class Parametro {

    //  guarda a única instância
    private static Parametro instancia;

    //  seus parâmetros universais
    private Integer idBloco;
    private String nomeBloco;

    public Integer getIdSindico() {
        return idSindico;
    }

    public void setIdSindico(Integer idSindico) {
        this.idSindico = idSindico;
    }
    private Integer idSindico;

    //  construtor privado (ninguém pode dar new)
    private Parametro() {}

    //  ponto de acesso global
    public static Parametro getInstance() {
        if (instancia == null) {
            instancia = new Parametro();
        }
        return instancia;
    }

    //  getters e setters
    public Integer getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(Integer idBloco) {
        this.idBloco = idBloco;
    }

    public String getNomeBloco() {
        return nomeBloco;
    }

    public void setNomeBloco(String nomeBloco) {
        this.nomeBloco = nomeBloco;
    }
}
