package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name="playlist")
@CascadeOnDelete
public class Playlist {
	@Id
	@GeneratedValue
	private int id;
	private String playlistName;
	
	// Constructors
	public Playlist() {
		super();
	}
	
	public Playlist(int id, String playlistName) {
		super();
		this.id = id;
		this.playlistName = playlistName;
	}
	
	public Playlist(String playlistName) {
		super();
		this.playlistName = playlistName;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	
	// toString
	@Override
	public String toString() {
		return "Playlist [id=" + id + ", playlistName=" + playlistName + "]";
	}
}
