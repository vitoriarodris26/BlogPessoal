package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //indica que é um modelo
@Table(name = "tb_postagens") //equivalente ao create table do MySQL
public class Postagem {

	@Id //chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT -> quem cria o valor da chave é o banco de dados
	private Long id; 
	
	@NotBlank(message = "O atributo Título é obrigatório e não pode utilizar apenas espaços em branco!") //mensagem para o usuário, notblank funciona apenas para texto/String
	@Size(min = 5, max =100, message = "O atributo Título deve conter no minino 05 e no máximo 100 caracteres!")  //tamanho minimo e máximo da String
	private String titulo;
	
	@NotNull(message = "O atributo Texto é obrigatório!") //mensagem para o usuário, notnull funciona apenas para texto/String e aceita espaço em branco
	@Size(min = 10, max =1000, message = "O atributo Texto deve conter no minino 10 e no máximo 1000 caracteres!")  //tamanho minimo e máximo da String
	private String texto;
	
	@UpdateTimestamp //pega a data direto do computador, muda a data toda vez que for criada ou atualizada a postagens, se quiser que seja só na criação utilizar o CreateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema; //Esse objeto cria a relação com a classe/tabela(chave estrangeira) Tema

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
		

}
