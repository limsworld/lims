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
import wold.lims.ejb.erp.model.entities.Geschaeftsbereich;

@Entity
@Table(name = "SYSTEM_USER", schema = "BASE", 
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class SystemUser extends AbstractEntityUniqueName {

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
	protected SystemRolle rolle;

	@ManyToOne
	@JoinColumn(name = "GESCHAEFTSEINHEIT_ID")	
	protected Geschaeftsbereich geschaeftseinheit;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLLE", schema = "erp", joinColumns = { 
			@JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ROLLE_ID", 
					nullable = false, updatable = false) })
	protected List<SystemRolle> rollen = new ArrayList<SystemRolle>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_GESCHAEFTSEINHEIT", schema = "erp", joinColumns = { 
			@JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "GESCHAEFTSEINHEIT_ID", 
					nullable = false, updatable = false) })
	protected List<Geschaeftsbereich> geschaeftseinheiten = new ArrayList<Geschaeftsbereich>();

	public SystemUser setSystem(boolean system) {
		this.system = system;
		return this;
	}

	public SystemUser setName(String name) {
		this.name = name;
		return this;
	}

	public String getPasswort() {
		return passwort;
	}

	public SystemUser setPasswort(String passwort) {
		this.passwort = passwort;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public SystemUser setEmail(String email) {
		this.email = email;
		return this;
	}

	public boolean isAktiviert() {
		return aktiviert;
	}

	public SystemUser setAktiviert(boolean aktiviert) {
		this.aktiviert = aktiviert;
		return this;
	}

	public List<SystemRolle> getRollen() {
		return rollen;
	}

	public SystemUser setRollen(List<SystemRolle> rollen) {
		this.rollen = rollen;
		return this;
	}

	public SystemUser addRolle(SystemRolle rolle) {
		rollen.add(rolle);
		return this;
	}

	public List<Geschaeftsbereich> getGeschaeftseinheiten() {
		return geschaeftseinheiten;
	}

	public SystemUser setGeschaeftseinheiten(List<Geschaeftsbereich> geschaeftseinheiten) {
		this.geschaeftseinheiten = geschaeftseinheiten;
		return this;
	}

	public SystemUser addGeschaeftseinheit(Geschaeftsbereich geschaeftseinheit) {
		geschaeftseinheiten.add(geschaeftseinheit);
		return this;
	}

	public String getAktivierungscode() {
		return aktivierungscode;
	}

	public SystemUser setAktivierungscode(String aktivierungscode) {
		this.aktivierungscode = aktivierungscode;
		return this;
	}

	public SystemRolle getRolle() {
		return rolle;
	}

	public SystemUser setRolle(SystemRolle rolle) {
		this.rolle = rolle;
		return this;
	}

	public Geschaeftsbereich getGeschaeftseinheit() {
		return geschaeftseinheit;
	}

	public SystemUser setGeschaeftseinheit(Geschaeftsbereich geschaeftseinheit) {
		this.geschaeftseinheit = geschaeftseinheit;
		return this;
	}

}
