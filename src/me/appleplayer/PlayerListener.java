package me.appleplayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.shampaggon.crackshot.events.WeaponScopeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener {

	ScopeFix plugin;
	
	public PlayerListener(ScopeFix plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}

	@EventHandler
	public void OnWeaponScope(WeaponScopeEvent event) {
		if (event.isZoomIn()) {
			try {
				Thread.sleep(plugin.getConfig().getInt("scope-delay"));
			} catch (InterruptedException e) {}
			
			event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 10000, 9));
		}
		else {
			event.getPlayer().removePotionEffect(PotionEffectType.SLOW_DIGGING);
		}
	}
}
