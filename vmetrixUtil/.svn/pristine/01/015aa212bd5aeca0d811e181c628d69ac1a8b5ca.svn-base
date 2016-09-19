package com.vmetrix.obtain.numLines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumLinesFile {
	
	private static final String FINDUR = "findur";
	private static final String CSV = ".csv";

	public static int getNumLines(File file) throws IOException{
		int nlineas =0;
		String sCadena="";
		FileReader fr=null;
		BufferedReader bf=null;
		try {
			fr = new FileReader(file.getCanonicalFile());
			 bf = new BufferedReader(fr);
			
			while ((sCadena = bf.readLine())!=null) {
				++nlineas;
				}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fr.close();
			bf.close();
		}
		
		if(file.getName().toLowerCase().contains(FINDUR) || file.getName().toLowerCase().contains(CSV)){
			--nlineas;
		}else{
			nlineas=nlineas-3;
		}
		
		return nlineas;
	}

}
