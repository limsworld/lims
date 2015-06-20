package wold.lims.ejb.base.model.base;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import wold.lims.ejb.base.model.entities.SystemUser;

@MappedSuperclass
public abstract class AbstractEntityUser extends AbstractEntityBase {

	private static final long serialVersionUID = -1913697205469322908L;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "USER_ID")	
	protected SystemUser user;


	public SystemUser getUser() {
		return user;
	}

	public AbstractEntityBase setUser(SystemUser user) {
		this.user = user;
		return this;
	}

}
