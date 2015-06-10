package wold.lims.ejb.base.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueName;

@Entity
@Table(
	name = "USER", 
	schema = "BASE", 
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class User extends AbstractEntityUniqueName {

	private static final long serialVersionUID = 1063439603938512155L;

	@NotNull
	@Column(name = "PASSWORT", length = 20)
	protected String passwort;

	@NotNull
	@Column(name = "EMAIL", length = 40)
	protected String email;

	@NotNull
	@Column(name = "AKTIVIERT", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean aktiviert;

	@Column(name = "AKTIVIERUNGSCODE", length = 32, columnDefinition = "char(32)")
	protected String aktivierungscode;

	@ManyToOne
	@JoinColumn(name = "ROLLE_ID")	
	protected Rolle rolle;

	@ManyToOne
	@JoinColumn(name = "GESCHAEFTSEINHEIT_ID")	
	protected Geschaeftsbereich geschaeftseinheit;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLLE", schema = "erp", joinColumns = { 
			@JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ROLLE_ID", 
					nullable = false, updatable = false) })
	protected List<Rolle> rollen = new ArrayList<Rolle>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_GESCHAEFTSEINHEIT", schema = "erp", joinColumns = { 
			@JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "GESCHAEFTSEINHEIT_ID", 
					nullable = false, updatable = false) })
	protected List<Geschaeftsbereich> geschaeftseinheiten = new ArrayList<Geschaeftsbereich>();

	public User setSystem(boolean system) {
		this.system = system;
		return this;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getPasswort() {
		return passwort;
	}

	public User setPasswort(String passwort) {
		this.passwort = passwort;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public boolean isAktiviert() {
		return aktiviert;
	}

	public User setAktiviert(boolean aktiviert) {
		this.aktiviert = aktiviert;
		return this;
	}

	public List<Rolle> getRollen() {
		return rollen;
	}

	public User setRollen(List<Rolle> rollen) {
		this.rollen = rollen;
		return this;
	}

	public User addRolle(Rolle rolle) {
		rollen.add(rolle);
		return this;
	}

	public List<Geschaeftsbereich> getGeschaeftseinheiten() {
		return geschaeftseinheiten;
	}

	public User setGeschaeftseinheiten(List<Geschaeftsbereich> geschaeftseinheiten) {
		this.geschaeftseinheiten = geschaeftseinheiten;
		return this;
	}

	public User addGeschaeftseinheit(Geschaeftsbereich geschaeftseinheit) {
		geschaeftseinheiten.add(geschaeftseinheit);
		return this;
	}

	public String getAktivierungscode() {
		return aktivierungscode;
	}

	public User setAktivierungscode(String aktivierungscode) {
		this.aktivierungscode = aktivierungscode;
		return this;
	}

	public Rolle getRolle() {
		return rolle;
	}

	public User setRolle(Rolle rolle) {
		this.rolle = rolle;
		return this;
	}

	public Geschaeftsbereich getGeschaeftseinheit() {
		return geschaeftseinheit;
	}

	public User setGeschaeftseinheit(Geschaeftsbereich geschaeftseinheit) {
		this.geschaeftseinheit = geschaeftseinheit;
		return this;
	}

}
