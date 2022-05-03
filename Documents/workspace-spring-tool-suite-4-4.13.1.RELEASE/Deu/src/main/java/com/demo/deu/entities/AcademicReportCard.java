package com.demo.deu.entities;
import java.util.Arrays;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="reportCard")
public class AcademicReportCard {
	
	
	     //@Id
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
       // private String id ;
	
	
	    @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid" , strategy = "uuid2")
        private String id ;

	
	
	private String fileName;
	private String fileType;
	
	
	@Lob
    private byte[] data ;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stuid", referencedColumnName = "uuid")
	private Student student;
	
	
	
	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}



	@Override
	public String toString() {
		return "AcademicReportCard [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
				+ Arrays.toString(data) + ", student=" + student + "]";
	}


	

    public AcademicReportCard(String id, String fileName, String fileType, byte[] data, Student student) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.student = student;
	}


	public AcademicReportCard()
    {}

    public AcademicReportCard(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }


    
}