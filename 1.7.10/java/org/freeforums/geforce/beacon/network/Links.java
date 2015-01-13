package org.freeforums.geforce.beacon.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Links {
	
	public static HashMap<String, String> webLinks = new HashMap<String, String>();
	public static HashMap<String, String> localMods = new HashMap<String, String>();
	public static HashMap<String, String> modAliases = new HashMap<String, String>();
	
	public static void setupLinks() throws IOException{
		URL modList = new URL("https://www.github.com/Geforce132/Beacon/raw/master/modList.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(modList.openStream()));
		
		String line;
		while((line = in.readLine()) != null){
			Scanner scanner = new Scanner(line);
			scanner.useDelimiter("~");
			
			List<String> modInfo = new ArrayList<String>();
			
			while(scanner.hasNext()){
				modInfo.add(scanner.next());
			}
			
			if(modInfo.size() == 2){ 
				webLinks.put(modInfo.get(1), modInfo.get(2));
			}else if(modInfo.size() == 3){ 
				webLinks.put(modInfo.get(1), modInfo.get(2));
				modAliases.put(modInfo.get(1), modInfo.get(3));
			}
		}
    }
	
	public static void setupLocalMods(){
		localMods.put("cfm v3.4.6", "C:/Users/Cyrell/Documents/Minecraft Mods/Working 1.7.10 Mods/Forge Requiring Mods/MrCrayfish's Furniture Mod 1.7.10 v3.4.6/MrCrayfishFurnitureModv3.4.6(1.7.10).jar");
		localMods.put("securitycraft v1.6.1", "C:/Users/Cyrell/Documents/Minecraft Mods/My Mods~Requires Forge~1.7.10/SecurityCraft v1.6.0 for 1.7.10.jar");
	}
	
	public static void setupAliases(){
		modAliases.put("cfm v3.4.6", "MrCrayfish's Furniture Mod v3.4.6");
	}
	
	public static String getLink(String mod){
		return webLinks.get(mod);
	}
	
	public static String getLocalModPath(String mod){
		return localMods.get(mod);
	}
	
	public static String getAlias(String mod){
		return modAliases.get(mod);
	}
	
	public static boolean hasWebLink(String mod){
		return webLinks.containsKey(mod);
	}
	
	public static boolean hasLocalMod(String mod){
		return localMods.containsKey(mod);
	}
	
	public static boolean hasAlias(String mod){
		return modAliases.containsKey(mod);
	}

	
}
