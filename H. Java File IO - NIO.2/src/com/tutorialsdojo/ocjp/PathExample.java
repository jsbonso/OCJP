package com.tutorialsdojo.ocjp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f = new File("test");
		f.createNewFile();
		
		Path p = Paths.get(f.getAbsolutePath());
		System.out.println("> "+ p.getFileName() + "\t| " + p.getParent() + " \t| " + p.getRoot()
				+" \n" + p.getFileSystem()  + " > " +  p.getName(0) + p.getName(1) + "\n" + 
				f.getPath() + "  | " + f.getAbsolutePath());
	}

}
