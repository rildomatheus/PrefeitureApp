package com.fafica.entidades;

public class Denuncia {
	
	private int idDenuncia;
	private String titulo;
	private String comentario;
	private String setor;
	private String cidade;
	private String bairro;
	private String descricao;
	private int idUsuario;
	private String foto;
	private String video;
	

	

	@Override
	public String toString() {
		return "Denuncia [idDenuncia=" + idDenuncia + ", titulo=" + titulo + ", comentario=" + comentario + ", setor="
				+ setor + ", cidade=" + cidade + ", bairro=" + bairro + ", descricao=" + descricao + ", idUsuario="
				+ idUsuario + ", foto=" + foto + ", video=" + video + "]";
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public int getIdDenuncia() {
		return idDenuncia;
	}
	public void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
