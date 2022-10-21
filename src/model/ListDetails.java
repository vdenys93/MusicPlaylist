package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@CascadeOnDelete
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate dateCreated;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Playlist playlist;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Song> listOfSongs;
	
	
	// Constructors 
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate dateCreated, Playlist playlist, List<Song> listOfSongs) {
		super();
		this.id = id;
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.playlist = playlist;
		this.listOfSongs = listOfSongs;
	}

	public ListDetails(String listName, LocalDate dateCreated, Playlist playlist, List<Song> listOfSongs) {
		super();
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.playlist = playlist;
		this.listOfSongs = listOfSongs;
	}

	public ListDetails(String listName, LocalDate dateCreated, Playlist playlist) {
		super();
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.playlist = playlist;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public List<Song> getListOfSongs() {
		return listOfSongs;
	}

	public void setListOfSongs(List<Song> listOfSongs) {
		this.listOfSongs = listOfSongs;
	}
	
	// toString
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", dateCreated=" + dateCreated + ", playlist="
				+ playlist + ", listOfSongs=" + listOfSongs + "]";
	}
	
	
}
