package net.softengine.security.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="SEC_AUTHORITY")
public class Authority implements Serializable{
	
	private static final long serialVersionUID = -7056246735190005660L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String name;
	private String description;
	
	@ManyToMany(mappedBy = "authorityList")
	private List<Group> groupList = new ArrayList<Group>(0);

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "sec_zt_authority_operation",
            joinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "operation_id", referencedColumnName = "id")})
    private List<Operation> operationList = new ArrayList<Operation>(0);

	public List<Operation> getOperationList() {
		return operationList;
	}
	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
