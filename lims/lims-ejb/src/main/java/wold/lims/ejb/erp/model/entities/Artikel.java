package wold.lims.ejb.erp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import wold.lims.ejb.base.model.base.AbstractEntityUserUniqueNameLang;
import wold.lims.ejb.base.model.entities.SystemUser;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISKRIMINATOR", length = 32)
@DiscriminatorValue("ARTIKEL")
@Table(name = "ARTIKEL", schema = "ERP")
public class Artikel extends AbstractEntityUserUniqueNameLang {

	private static final long serialVersionUID = -1067289216579492822L;

	@Column(name = "NUMMER", length = 20)
    protected String nummer;

	@Column(name = "PREIS")
	protected double preis;

	@NotNull
	@Column(name = "VERWENDEN", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean verwenden;

	@NotNull
	@Column(name = "PREISAUSGEBEN", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean preisausgeben;

	@ManyToOne
	@JoinColumn(name = "EINHEIT_ID")	
	protected Einheit einheit;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ARTIKEL_ARTIKELGRUPPE", schema = "erp", joinColumns = { 
			@JoinColumn(name = "ARTIKEL_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ARTIKELGRUPPE_ID", 
					nullable = false, updatable = false) })
	protected List<Artikelgruppe> artikelgruppen = new ArrayList<Artikelgruppe>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ARTIKEL_NORM", schema = "erp", joinColumns = { 
			@JoinColumn(name = "ARTIKEL_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "NORM_ID", 
					nullable = false, updatable = false) })
	protected List<Norm> normen = new ArrayList<Norm>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ARTIKEL_ARTIKEL", schema = "erp", joinColumns = { 
			@JoinColumn(name = "ARTIKEL_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ARTIKEL2_ID", 
					nullable = false, updatable = false) })
	protected List<Artikel> artikels = new ArrayList<Artikel>();

	public Artikel setUser(SystemUser user) {
		this.user = user;
		return this;
	}

	public Artikel setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public String getNummer() {
		return nummer;
	}

	public Artikel setNummer(String nummer) {
		this.nummer = nummer;
		return this;
	}

	public List<Artikelgruppe> getArtikelgruppen() {
		return artikelgruppen;
	}

	public Artikel setArtikelgruppen(List<Artikelgruppe> artikelgruppen) {
		this.artikelgruppen = artikelgruppen;
		return this;
	}

	public Artikel addArtikelgruppe(Artikelgruppe artikelgruppe) {
		artikelgruppen.add(artikelgruppe);
		return this;
	}

	public List<Norm> getNormen() {
		return normen;
	}

	public Artikel setNormen(List<Norm> normen) {
		this.normen = normen;
		return this;
	}

	public Artikel addNormen(Norm norm) {
		normen.add(norm);
		return this;
	}

	public List<Artikel> getArtikels() {
		return artikels;
	}

	public Artikel setArtikels(List<Artikel> artikels) {
		this.artikels = artikels;
		return this;
	}

	public Artikel addArtikel(Artikel artikel) {
		artikels.add(artikel);
		return this;
	}

	public double getPreis() {
		return preis;
	}

	public Artikel setPreis(double preis) {
		this.preis = preis;
		return this;
	}

	public boolean isPreisausgeben() {
		return preisausgeben;
	}

	public Artikel setPreisausgeben(boolean preisausgeben) {
		this.preisausgeben = preisausgeben;
		return this;
	}

	public boolean isVerwenden() {
		return verwenden;
	}

	public Artikel setVerwenden(boolean verwenden) {
		this.verwenden = verwenden;
		return this;
	}

	public Einheit getEinheit() {
		return einheit;
	}

	public Artikel setEinheit(Einheit einheit) {
		this.einheit = einheit;
		return this;
	}

}
