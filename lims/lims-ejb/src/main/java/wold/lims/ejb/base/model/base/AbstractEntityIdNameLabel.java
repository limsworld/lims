package wold.lims.ejb.base.model.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntityIdNameLabel extends AbstractEntityId {

	private static final long serialVersionUID = 3898056836052131067L;

	@Column(name = "NAME", length = 80)
    protected String name;
	
	@Column(name = "TEXT", length = 255)
    protected String text;

	public String getId() {
		return id;
	}

	public AbstractEntityIdNameLabel setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public AbstractEntityIdNameLabel setName(String name) {
		this.name = name;
		return this;
	}

	public String getText() {
		return text;
	}

	public AbstractEntityIdNameLabel setText(String text) {
		this.text = text;
		return this;
	}

}
