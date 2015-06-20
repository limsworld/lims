package wold.lims.ejb.base.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import wold.lims.ejb.base.model.base.AbstractEntityUniqueNameLang;

@Entity
@Table(name = "SYSTEM_ROLLE", schema = "BASE",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class SystemRolle extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = 5717618395956266025L;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rollen")
	protected List<SystemUser> users = new ArrayList<SystemUser>();

	public SystemRolle setSystem(boolean system) {
		this.system = system;
		return this;
	}

	public SystemRolle setName(String name) {
		this.name = name;
		return this;
	}

	public SystemRolle setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public List<SystemUser> getUsers() {
		return users;
	}

	public SystemRolle setUsers(List<SystemUser> users) {
		this.users = users;
		return this;
	}

	public SystemRolle addUser(SystemUser user) {
		users.add(user);
		return this;
	}

}
