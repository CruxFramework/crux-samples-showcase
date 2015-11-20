package org.cruxframework.crossdeviceshowcase.client.util.dataobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DiscDTO implements Serializable
{	
	private static final long serialVersionUID = -4135882705373439428L;
	
	private String discName;
	private String artistName;
	private int releaseYear;
	private int stock;
	
	public DiscDTO()
	{
	}
	
	public DiscDTO(String discName, String artistName, int releaseYear, int stock)
	{
		this.discName = discName;
		this.artistName = artistName;
		this.releaseYear = releaseYear;
		this.stock = stock;
	}

	public String getDiscName() {
		return discName;
	}

	public void setDiscName(String discName) {
		this.discName = discName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public static List<DiscDTO> getList()
	{
		List<DiscDTO> discList = new ArrayList<DiscDTO>();
		
		discList.add(new DiscDTO("Journals", "Justin Bieber", 2013, 239));
		discList.add(new DiscDTO("Sheezus (Deluxe)", "Lily Allen", 2014, 75));
		discList.add(new DiscDTO("Xscape", "Michael Jackson", 2014, 33));
		discList.add(new DiscDTO("Unapologetic", "Rihanna", 2012, 346));
		discList.add(new DiscDTO("21", "Adele", 2011, 14));
		
		discList.add(new DiscDTO("The 20/20 Experience", "Justin Timberlake", 2013, 23));
		discList.add(new DiscDTO("Ghost Stories", "Coldplay", 2014, 176));
		discList.add(new DiscDTO("Ultraviolence", "Lana Del Rey", 2014, 99));
		discList.add(new DiscDTO("Bangerz", "Miley Cyrus", 2013, 199));
		discList.add(new DiscDTO("Unorthodox Jukebox", "Bruno Mars", 2012, 17));
		
		discList.add(new DiscDTO("Continued Silence", "Imagine Dragons", 2012, 34));
		discList.add(new DiscDTO("Girl", "Pharrell Williams", 2014, 57));
		discList.add(new DiscDTO("Demi", "Demi Lovato", 2013, 42));
		discList.add(new DiscDTO("Beyoncé", "Beyoncé", 2013, 123));
		discList.add(new DiscDTO("Midnight Memories", "One Direction", 2013, 41));
		
		discList.add(new DiscDTO("X", "Ed Sheeran", 2014, 35));
		discList.add(new DiscDTO("Shakira", "Shakira", 2014, 39));
		discList.add(new DiscDTO("Prism", "Katy Perry", 2013, 16));
		discList.add(new DiscDTO("Avril Lavigne", "Avril Lavigne", 2013, 11));
		discList.add(new DiscDTO("The Marshall Mathers LP 2", "Eminem", 2013, 27));
		
		return discList;
	}
}
