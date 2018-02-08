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
 * class to extract accuracy from results from prediction methods executed with training set on WEKA (ONLY)
 *
 */

public class ResultTrainingSet implements ResultExtractor {

	private BufferedReader br;
	
	@Override
	public ArrayList<ResultFromMethod> extractResult(File file) throws IOException {
		
		ArrayList<ResultFromMethod> results = new ArrayList<ResultFromMethod>();
		br = new BufferedReader(new FileReader(file));
		int trainingSplit = 0;
		int testSplit = 0;
		ResultFromMethod rf;
		AccuracyCatch accuracyCatch = new AccuracyCatch();
		
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			
			//TRAINING SPLIT RESULT
			if (line.contains("Error on training split")){
				trainingSplit++;
			}
			
			//TEST SPLIT RESULT
			if (line.contains("Error on test split")){
				testSplit++;
			}
			
			if(line.contains("Correctly Classified Instances")) {
				if(trainingSplit > 0) {
					
					rf= new ResultFromMethod();
					rf.setFileName(file.getName());
					rf.setAccuracy(accuracyCatch.getAccuracy(line));
					rf.setMethodStepName("training split");
					
					trainingSplit = 0;
					results.add(rf);
				}
				else if(testSplit > 0) {
					rf= new ResultFromMethod();
					rf.setFileName(file.getName());
					rf.setAccuracy(accuracyCatch.getAccuracy(line));
					rf.setMethodStepName("test split");
					results.add(rf);
				}
			}
		}
		return results;
	}

}
