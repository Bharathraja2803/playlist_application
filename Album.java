import java.util.ArrayList;

public class Album {
    private String albumName;
    private ArrayList<Songs> songsList;

    public Album(String albumName){
        this.albumName = albumName;
        this.songsList = new ArrayList<Songs>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public ArrayList<Songs> getSongsList() {
        return songsList;
    }


    public boolean addSongsInAlbum(Songs newSongs){
        if(findSong(newSongs)==null){
            //System.out.println("The song"+newSongs.getSongName()+" is getting adding to the "+this.albumName+" albums....");
            songsList.add(newSongs);
            return true;
        }else {
            //System.out.println("The entered song is already is exist");
            return false;
        }
    }

    public boolean removeSongInAlbum(Songs song){
        if(findSong(song)!=null){
            System.out.println("The song "+song.getSongName()+"is removing from the "+this.albumName+" album list...");
            songsList.remove(song);
            return true;
        }else {
            System.out.println("The entered song is not in the album");
            return false;
        }
    }



    private Songs findSong(Songs songs){
        for(int i =0;i<songsList.size();i++){
            Songs listSong = songsList.get(i);
            if(songs.getSongName().equals(listSong.getSongName())){
                return listSong;
            }
        }
        return null;

    }
}
