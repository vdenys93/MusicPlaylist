import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.PlaylistHelper;
import model.ListDetails;
import model.Playlist;
import model.Song;

public class ListDetailsTester {

	public static void main(String[] args) {
		Playlist study = new Playlist("Study");
		PlaylistHelper ph = new PlaylistHelper();
		
		ph.insertPlaylist(study);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		Song power = new Song("Power", "Kanye West");
		Song cleopatra = new Song("Cleopatra", "The Lumineers");
		
		List<Song> newList = new ArrayList<Song>();
		newList.add(power);
		newList.add(cleopatra);
		
		ListDetails studyList = new ListDetails("Study Playlist", LocalDate.now(), study);
		
		ldh.insertNewListDetails(studyList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}

	}

}
