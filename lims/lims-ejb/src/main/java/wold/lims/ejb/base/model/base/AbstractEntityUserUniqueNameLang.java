package wold.lims.ejb.base.model.base;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import wold.lims.ejb.base.model.entities.User;

@MappedSuperclass
public abstract class AbstractEntityUserUniqueNameLang extends AbstractEntityBase {

	private static final long serialVersionUID = 5648090950896807525L;

	@Column(name = "NAME", length = 120)
    protected String name;
	
	@Column(name = "BEZEICHNUNG", length = 240)
    protected String bezeichnung;

	@ManyToOne
	@JoinColumn(name = "USER_ID")	
	protected User user;

	public String getName() {
		return name;
	}

	public AbstractEntityUserUniqueNameLang setName(String name) {
		this.name = name;
		return this;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public AbstractEntityUserUniqueNameLang setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public User getUser() {
		return user;
	}

	public AbstractEntityUserUniqueNameLang setUser(User user) {
		this.user = user;
		return this;
	}

}
