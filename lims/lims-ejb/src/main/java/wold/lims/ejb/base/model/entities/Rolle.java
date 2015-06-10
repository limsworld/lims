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
@Table(
	name = "ROLLE",
	schema = "BASE",
	uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Rolle extends AbstractEntityUniqueNameLang {

	private static final long serialVersionUID = 5717618395956266025L;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rollen")
	protected List<User> users = new ArrayList<User>();

	public Rolle setSystem(boolean system) {
		this.system = system;
		return this;
	}

	public Rolle setName(String name) {
		this.name = name;
		return this;
	}

	public Rolle setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public List<User> getUsers() {
		return users;
	}

	public Rolle setUsers(List<User> users) {
		this.users = users;
		return this;
	}

	public Rolle addUser(User user) {
		users.add(user);
		return this;
	}

}
