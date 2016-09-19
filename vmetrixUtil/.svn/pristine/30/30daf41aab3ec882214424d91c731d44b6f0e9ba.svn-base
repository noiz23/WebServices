package com.vmetrix.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
	
	public static void backupFile(File source) throws IOException {
		String fileOriginalName = source.getCanonicalPath().substring(0, source.getCanonicalPath().length() - 4);
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd HHmmss");
		source.renameTo(new File(fileOriginalName + "_" + ft.format(dNow) + ".bak"));

	}

	public static void renameFile(File source, String txt) throws IOException {
		String typeFile = source.getCanonicalPath().substring(source.getCanonicalPath().length() - 4,source.getCanonicalPath().length());
		String fileOriginalName = source.getCanonicalPath().substring(0, source.getCanonicalPath().length() - 4);
		if (!fileOriginalName.contains(txt)) {
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd HHmmss");
			source.renameTo(new File(fileOriginalName + "_" + txt + "_" + ft.format(dNow) + typeFile));
		}
	}	
}
