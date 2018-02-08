package br.ufrn.imd.master.ia.resultExtractors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.imd.master.ia.domain.ResultFromMethod;

/**
 * 
 * @author cephas
 *
 * class to extract accuracy from results from prediction methods executed with cross-validation on WEKA (ONLY)
 *
 */

public class ResultCrossValidation implements ResultExtractor {

	private BufferedReader br;
	
	@Override
	public ArrayList<ResultFromMethod> extractResult(File file) throws IOException {
		
		ArrayList<ResultFromMethod> results = new ArrayList<ResultFromMethod>();
		br = new BufferedReader(new FileReader(file));
		int trainingSplit = 0;
		int crossvalidation = 0;
		ResultFromMethod rf;
		AccuracyCatch accuracyCatch = new AccuracyCatch();
		
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			
			//TRAINING SPLIT RESULT
			if (line.contains("Error on training data")){
				trainingSplit++;
			}
			
			//CROSS-VALIDATION RESULT
			if (line.contains("Stratified cross-validation")){
				crossvalidation++;
			}
			
			if(line.contains("Correctly Classified Instances")) {
				if(trainingSplit > 0) {
					
					rf= new ResultFromMethod();
					rf.setFileName(file.getName());
					rf.setAccuracy(accuracyCatch.getAccuracy(line));
					rf.setMethodStepName("training data");
					
					trainingSplit = 0;
					results.add(rf);
				}
				else if(crossvalidation > 0) {
					rf= new ResultFromMethod();
					rf.setFileName(file.getName());
					rf.setAccuracy(accuracyCatch.getAccuracy(line));
					rf.setMethodStepName("cross validation set");
					
					crossvalidation = 0;
					results.add(rf);
				}
			}
		}
		return results;
	}

}
