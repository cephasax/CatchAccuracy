package br.ufrn.imd.master.ia.resultExtractors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.imd.master.ia.domain.ResultFromMethod;

public interface ResultExtractor {

	public ArrayList<ResultFromMethod> extractResult(File file) throws FileNotFoundException, IOException;
	
}
