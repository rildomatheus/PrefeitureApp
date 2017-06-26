package com.fafica.entidades;

public class Comentario {
	
	int idComentario;
	String descricao;
	int idDenuncia;
	int idUsuario;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdDenuncia() {
		return idDenuncia;
	}
	public void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
	}
	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", descricao=" + descricao + ", idDenuncia=" + idDenuncia
				+ ", idUsuario=" + idUsuario + "]";
	}	
	

}
