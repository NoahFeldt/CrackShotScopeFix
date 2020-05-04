package me.appleplayer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.bukkit.plugin.java.JavaPlugin;
import com.shampaggon.crackshot.CSUtility;

public class ScopeFix extends JavaPlugin {
	
	CSUtility util;
	YAML yaml = new YAML();
	
	@Override
	public void onEnable() {
		File dir = new File("plugins/ApplePlugin");
		if(dir.exists())
		{
			if (Files.notExists(Paths.get("plugins/ApplePlugin/config.yml"))) {
				yaml.makeYAML();
			}
		}
		else {
			dir.mkdir();
			yaml.makeYAML();
		}
		
		new PlayerListener(this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
