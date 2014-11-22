package com.tutorialsdojo.ocjp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.BasicFileAttributeView;

public class PosixFileAttributesExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File naruto = new File("Naruto.txt");
		File sasuke = new File("/darkside/Sasuke.txt");
		naruto.createNewFile();
		sasuke.createNewFile();
		Path narutoPath = Paths.get(naruto.toURI());
		Path sasukePath = Paths.get(sasuke.toURI());
		
		System.out.println(" NARUTO " );
		System.out.println(" Relativize: " + narutoPath.relativize(sasukePath));
		System.out.println(" Resolve: " + narutoPath.resolve(sasukePath));

		System.out.println(" SASUKE " );
		System.out.println(" Relativize: " + sasukePath.relativize(narutoPath));
		System.out.println(" Resolve: " + sasukePath.resolve(narutoPath));
		
	}

}
