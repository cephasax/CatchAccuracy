package br.ufrn.imd.master.ia.resultExtractors;

public class AccuracyCatch {

	public float getAccuracy(String lineText) {
		
		String accuracyText = new String();
		accuracyText = lineText.substring(lineText.length()-10, lineText.length()-2);
		float value = Float.valueOf(accuracyText.trim());
		return value;
	}
}
	

