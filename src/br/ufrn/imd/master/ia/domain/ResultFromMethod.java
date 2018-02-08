package br.ufrn.imd.master.ia.domain;

public class ResultFromMethod {

	private String fileName;
	private String methodName;
	private String methodStepName;
	private float accuracy;
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String getMethodStepName() {
		return methodStepName;
	}
	
	public void setMethodStepName(String methodStepName) {
		this.methodStepName = methodStepName;
	}
	
	public float getAccuracy() {
		return accuracy;
	}
	
	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	@Override
	public String toString() {
		return fileName + " - " + methodStepName + " - " + accuracy;
	}
	
	
}
