package com.Funcionarios2;

import java.util.List;

public class Funcionario{
    private int id;
    private String nome;
    private String sobrenome;
    private float salario;
    private String area;

    public Funcionario(int id, String nome, String sobrenome, float salario, String area){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.area = area;
    }
    public Funcionario(){

    }


    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getArea() {
        return area;
    }

    public float getSalario() {
        return salario;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
