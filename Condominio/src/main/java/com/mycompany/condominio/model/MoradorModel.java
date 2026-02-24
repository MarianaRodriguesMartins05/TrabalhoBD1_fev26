/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.condominio.model;

/**
 *
 * @author Mariana
 */
public class MoradorModel {
    
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private int numUnidade;

    public MoradorModel() {
    }

    public MoradorModel(String cpf, String nome, String telefone, String email, int numUnidade) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.numUnidade = numUnidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumUnidade() {
        return numUnidade;
    }

    public void setNumUnidade(int numUnidade) {
        this.numUnidade = numUnidade;
    }

    
    
}
