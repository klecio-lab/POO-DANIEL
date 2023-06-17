package com.poo.poo.model;

import jakarta.persistence.*;

@Entity
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String rua;

  @Column(nullable = false)
  private String numero;

  @Column(nullable = false)
  private String cidade;

  @Column(nullable = false)
  private String estado;

  @Column(nullable = false)
  private String pais;

  @Column(nullable = false)
  private String cep;


  @OneToOne
  private Usuario usuario;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public Usuario getContato() {
    return usuario;
  }

  public void setContato(Usuario contusuarioato) {
    this.usuario = usuario;
  }

}
