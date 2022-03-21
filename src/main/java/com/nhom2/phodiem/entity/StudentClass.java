package com.nhom2.phodiem.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studentClasses")
@Entity
public class StudentClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentClassId;
	
	
	@ManyToOne
	@JoinColumn(name = "mClassId")
	private MClass mClass;
	
	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;
	
	@OneToMany(mappedBy = "studentClass",cascade = CascadeType.ALL)
	private Set<Mark> marks;
}
