package me.appleplayer;

import org.bukkit.plugin.java.JavaPlugin;
import com.shampaggon.crackshot.CSUtility;

public class ScopeFix extends JavaPlugin {
	
	CSUtility util;
	
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		new PlayerListener(this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
