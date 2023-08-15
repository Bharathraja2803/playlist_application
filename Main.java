import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static PlayList playList = new PlayList("Favourite");
    private static LinkedList<String> songs = new LinkedList<String>();

    private static ListIterator<String> songListIterator = songs.listIterator();




    public static void main(String[] args) {
        playList.addingPlaylist();
        boolean quit = false;

        int choice = 0;
        int songIndex = 0;
        while (!quit) {


            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    playList.viewPlayList();
                    break;
                case 2:
                    startPlaying();
                    break;
                case 3:
                    moveNext(++songIndex);
                    break;
                case 4:
                    movePrevious(--songIndex);
                    break;
                case 5:
                    addAlbum();
                    break;
                case 6:
                    addSongs();
                    break;
                case 7:
                    quit =true;
                    continue;
                default:
                    System.out.println("Enter valid input");
                    break;
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            addSongsToPlaylist();

        }
    }

    private static void addSongsToPlaylist(){
        for (int i = 0; i < playList.getAlbums().size(); i++) {
            Album album = playList.getAlbums().get(i);
            for (int j = 0; j < album.getSongsList().size(); j++) {
                Songs songs1 = album.getSongsList().get(j);
                songs.add(songs1.getSongName());

            }

        }
    }
    private static void printMenu(){
        System.out.println("press 0 -> print the menu\n" +
                "press 1 -> view list of all songs and albums\n" +
                "press 2 -> start playing\n" +
                "press 3 -> move to next song \n" +
                "press 4 -> move to previous song \n" +
                "press 5 -> add album\n" +
                "press 6 -> add song\n" +
                "press 7 -> quit");

    }

    private static void addSongs(){
        System.out.println("Enter the album name in which the song to be added");
        String albumName = scanner.nextLine();
        System.out.println("Enter the Song name");
        String songName = scanner.nextLine();
        System.out.println("Enter the duration of the song");
        double songDuration = scanner.nextDouble();
        if(albumIsAvailable(albumName)!=null){
            if(isAvailable(songName)){
                System.out.println("The entered song is already available");

            }else {
                albumIsAvailable(albumName).getSongsList().add(new Songs(songName, songDuration));
                System.out.println("The Song is successfully added");
            }
        }

    }


    private static void addAlbum(){
        System.out.println("Enter the Album name");
        String albumName = scanner.nextLine();
        if(albumIsAvailable(albumName)==null){
            playList.getAlbums().add(new Album(albumName));
            System.out.println("The album "+albumName+" is successfully added to the playlist");
        }else {
            System.out.println("The entered album name is already exists");
        }
    }
    private static Album albumIsAvailable(String albumName){
        for(int i =0;i<playList.getAlbums().size();i++){
            Album album = playList.getAlbums().get(i);
            if(album.getAlbumName().equals(albumName)){
                return album;
            }
        }
        return null;
    }

    private static void startPlaying(){
        System.out.println("The" + playList.getPlayListName() + " playlist ia ready to play");

        if (isAvailable(songs.getFirst())) {
            System.out.println("Now playing -> " + songs.getFirst());
        } else {
            System.out.println("Entered song not in the list");

        }

    }

    private static void movePrevious(int index){
     if(index<0){
         System.out.println("This is the 1st song in ths list ");
     }else {
         System.out.println("Now playing -> "+songs.get(index));
     }
    }

    private static void moveNext(int index){
        if(index>=songs.size()-1){
            System.out.println("This is the last song in the list");
        }else {
            System.out.println("Now playing -> "+songs.get(index));

        }

    }

    private static boolean isAvailable (String name){

        for (int i = 0; i < playList.getAlbums().size(); i++) {
            Album album = playList.getAlbums().get(i);
            for (int j = 0; j < album.getSongsList().size(); j++) {
                Songs songs1 = album.getSongsList().get(j);

                if (name.equals(songs1.getSongName())) {
                    return true;

                }

            }
        }
        return false;
    }


}

