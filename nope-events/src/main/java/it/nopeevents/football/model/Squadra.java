package it.nopeevents.football.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Squadra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String nome;
	
	private String telefono;
	
	private String email;
	
	@NotEmpty
	@ManyToMany
	private List<Torneo> tornei;
	
	public Squadra(String nome) {
		this.nome = nome;
	}
	
	public Squadra() {
		this(null);
	}

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public List<Torneo> getTornei() {
		return tornei;
	}

	public void setTornei(List<Torneo> tornei) {
		this.tornei = tornei;
	}

	@Override
	public boolean equals(Object obj) {
		Squadra s = (Squadra) obj;
		return this.getId() == s.getId();
	}
}
