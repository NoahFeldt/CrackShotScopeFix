package me.appleplayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

public class YAML {
	public void makeYAML() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("plugins/ApplePlugin/config.yml", "UTF-8");
		} 
		catch (FileNotFoundException e) {} 
		catch (UnsupportedEncodingException e) {}
		
		writer.println("ScopeDelay: 300");
		writer.close();
	}
	
	public int[] readYAML() {
		List<String> content = new Vector<String>();

		try {
			content = Files.readAllLines(Paths.get("plugins/ApplePlugin/config.yml"));
		} catch (IOException e) {}
		
		int[] values = new int[content.size()];
		
		for (int i = 0; i < content.size(); i++) {
			values[i] = Integer.parseInt(content.get(i).split(" ")[1]);
		}
		
		return values;
	}
}
