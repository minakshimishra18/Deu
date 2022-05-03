package com.demo.deu.customresponse;

public class ResponseAttachment {

	
	private String fileName;
    private String fileType;
    private String downloadURL;
    private long fileSize;
    
    
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
	public String getDownloadURL() {
		return downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	
	@Override
	public String toString() {
		return "ResponseAttachment [fileName=" + fileName + ", fileType=" + fileType + ", downloadURL=" + downloadURL
				+ ", fileSize=" + fileSize + "]";
	}
	
	
	public ResponseAttachment(String fileName, String fileType, String downloadURL, long fileSize) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.downloadURL = downloadURL;
		this.fileSize = fileSize;
	}

	  public ResponseAttachment() {}
 }