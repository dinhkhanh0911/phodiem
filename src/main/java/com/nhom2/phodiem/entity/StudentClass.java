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

	public long getStudentClassId() {
		return studentClassId;
	}

	public void setStudentClassId(long studentClassId) {
		this.studentClassId = studentClassId;
	}

//	public MClass getmClass() {
//		return mClass;
//	}
//
//	public void setmClass(MClass mClass) {
//		this.mClass = mClass;
//	}
//
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//	public Set<Mark> getMarks() {
//		return marks;
//	}
//
//	public void setMarks(Set<Mark> marks) {
//		this.marks = marks;
//	}
//	
	
	
}
