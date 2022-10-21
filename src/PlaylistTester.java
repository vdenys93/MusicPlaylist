

import java.util.List;

import controller.PlaylistHelper;
import model.Playlist;

public class PlaylistTester {
	
	public static void main(String[] args) {
	
	Playlist gym = new Playlist("Gym");
	PlaylistHelper ph = new PlaylistHelper();
	
	ph.insertPlaylist(gym);
	
	List<Playlist> allPlaylists = ph.showAllPlaylists();
	for(Playlist a: allPlaylists) {
		System.out.println(a.toString());
	}	
	}
}
