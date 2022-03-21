package com.query.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "testes")
public class Teste implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date;
	private String candidat;
	@Min(value = 0)
	private int note;
	private String remarque;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCandidat() {
		return candidat;
	}
	public void setCandidat(String candidat) {
		this.candidat = candidat;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	@Override
	public String toString() {
		return "Teste [id=" + id + ", date=" + date + ", candidat=" + candidat + ", note=" + note + ", remarque="
				+ remarque + "]";
	}
	public Teste() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teste(String date, String candidat, @Min(0) int note, String remarque) {
		super();
		this.date = date;
		this.candidat = candidat;
		this.note = note;
		this.remarque = remarque;
	}
	

}
