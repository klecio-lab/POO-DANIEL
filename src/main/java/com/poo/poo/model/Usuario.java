package com.poo.poo.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String nome;
  @Column(nullable = false)
  private String telefone;
  @Column(nullable = false)
  private String email;
  @Column(nullable = false)
  private String urlAvatar;

  @OneToOne(mappedBy = "usuario")
  private Endereco endereco;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
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
  public String getUrlAvatar() {
    return urlAvatar;
  }
  public void setUrlAvatar(String urlAvatar) {
    this.urlAvatar = urlAvatar;
  }


}
