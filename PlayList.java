import java.util.ArrayList;

public class PlayList {

    private String playListName;

    public PlayList(String playListName) {
        this.playListName = playListName;
    }

    public String getPlayListName() {
        return playListName;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    private ArrayList <Album> albums = new ArrayList<Album>();

    public void addingPlaylist(){

        Album rahman = new Album("rahman");
        Album gvprakash = new Album("gvprakash");
        Album aniruth = new Album("aniruth");
        Album yuvan = new Album("yuvan");
        albums.add(rahman);
        albums.add(gvprakash);
        albums.add(aniruth);
        albums.add(yuvan);
        rahman.addSongsInAlbum(new Songs("aashira",4.19D));
        rahman.addSongsInAlbum(new Songs("kalathukkum",4.55D));
        rahman.addSongsInAlbum(new Songs("mukkala",5.23D));

        gvprakash.addSongsInAlbum(new Songs("sandaliyae",4.19D));
        gvprakash.addSongsInAlbum(new Songs("adiyae",4.33D));
        gvprakash.addSongsInAlbum(new Songs("kaththodu",5.11D));

        aniruth.addSongsInAlbum(new Songs("arabic",4.39));
        aniruth.addSongsInAlbum(new Songs("paththala",3.31));
        aniruth.addSongsInAlbum(new Songs("halamathi",4.39));

        yuvan.addSongsInAlbum(new Songs("orunalil",4.31));
        yuvan.addSongsInAlbum(new Songs("oruparvaiyil",2.50));



    }

    public void viewPlayList(){
        System.out.println("Welcome to "+playListName+" Playlist\n" +
                "Here are the songs for you");

        for (int i =0;i<albums.size();i++){
            Album album = albums.get(i);
            System.out.println("Album -> "+album.getAlbumName());
            for (int j=0;j<album.getSongsList().size();j++){
                Songs songs = album.getSongsList().get(j);
                System.out.println("["+(j+1)+"]"+songs.getSongName()+" -> Duration : "+songs.getDuration());

            }
            }

    }







}
