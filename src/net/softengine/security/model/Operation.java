package net.softengine.security.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="SEC_OPERATION")
public class Operation implements Serializable {
	
	private static final long serialVersionUID = 8506032467669918398L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "operationList")
    @Fetch(value = FetchMode.SELECT)
    private List<Authority> authorityList = new ArrayList<Authority>(0);
    
    
	public List<Authority> getAuthorityList() {
		return authorityList;
	}
	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
