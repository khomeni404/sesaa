package net.softengine.common.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Office")
public class OfficeAddress extends Address implements Serializable {


}
