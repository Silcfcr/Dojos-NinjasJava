package com.silcfcr.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="dojos")
public class Dojo {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
 private List<Ninja> ninjas;
 
 public Dojo() {
     
 }

public Long getId() {
	return id;
}

public String getName() {
	return name;
}

public Date getCreatedAt() {
	return createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public List<Ninja> getNinjas() {
	return ninjas;
}

public void setId(Long id) {
	this.id = id;
}

public void setName(String name) {
	this.name = name;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public void setNinjas(List<Ninja> ninjas) {
	this.ninjas = ninjas;
}

@PrePersist
protected void onCreate() {
	this.createdAt = new Date();
}
@PostPersist
protected void onUpdate() {
	this.updatedAt = new Date();
}

}
