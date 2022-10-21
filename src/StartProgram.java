import java.util.List;
import java.util.Scanner;

import controller.SongHelper;
import model.Song;

public class StartProgram {

		static Scanner s = new Scanner(System.in);
		static SongHelper sh = new SongHelper();

		private static void addSong() {
			System.out.print("Enter the song title: ");
			String title = s.nextLine();
			System.out.print("Enter the artist: ");
			String artist = s.nextLine();
			
			Song toAdd = new Song(title, artist);
			sh.insertSong(toAdd);
		}

		private static void deleteSong() {
			System.out.print("Enter the title to delete: ");
			String title = s.nextLine();
			System.out.print("Enter the artist to delete: ");
			String artist = s.nextLine();

			Song toDelete = new Song(title, artist);
			sh.deleteSong(toDelete);
		}

		private static void editSong() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Song Title");
			System.out.println("2 : Search by Artist");
			int searchBy = s.nextInt();
			s.nextLine();
			List<Song> foundSongs;
			if (searchBy == 1) {
				System.out.print("Enter the Song Title: ");
				String songTitle = s.nextLine();
				foundSongs = sh.searchForSongByTitle(songTitle);
				
			} 
			else {
				System.out.print("Enter the artist: ");
				String songArtist = s.nextLine();
				foundSongs = sh.searchForSongByArtist(songArtist);

			}

			if (!foundSongs.isEmpty()) {
				System.out.println("Found Results.");
				for (Song s : foundSongs) {
					System.out.println(s.getId() + " : " + s.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = s.nextInt();

				Song toEdit = sh.searchForSongById(idToEdit);
				System.out.println("Retrieved '" + toEdit.getTitle() + "', by " + toEdit.getArtist());
				System.out.println("1 : Update Title");
				System.out.println("2 : Update Artist");
				int update = s.nextInt();
				s.nextLine();

				if (update == 1) {
					System.out.print("New Title: ");
					String newTitle = s.nextLine();
					toEdit.setTitle(newTitle);
				} else if (update == 2) {
					System.out.print("New Artist: ");
					String newArtist = s.nextLine();
					toEdit.setArtist(newArtist);
				}

				sh.updateSong(toEdit);

			} else {
				System.out.println("--- No results found ---");
			}

		}

		public static void main(String[] args) {
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- MUSIC APP! ---");
			while (goAgain) {
				System.out.println("*  Select an option:");
				System.out.println("*  1 -- Add a Song");
				System.out.println("*  2 -- Edit an existing Song");
				System.out.println("*  3 -- Delete a Song");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit");
				System.out.print("*  Your selection: ");
				int selection = s.nextInt();
				s.nextLine();

				if (selection == 1) {
					addSong();
				} else if (selection == 2) {
					editSong();
				} else if (selection == 3) {
					deleteSong();
				} else if (selection == 4) {
					viewTheList();
				} else {
					sh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Song> allSongs = sh.showAllSongs();
			
			for(Song singleSong: allSongs) {
				System.out.println(singleSong.returnSongDetails());
			}
		}

	}
