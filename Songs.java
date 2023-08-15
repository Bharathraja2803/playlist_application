public class Songs {
    private String songName;
    private double duration;

    public Songs(String songName,double duration){
        if(songName.isEmpty()||duration<=0.0D){
            //System.out.println("The entered song is not valid");
            this.songName = null;
            this.duration = 0.0D;
        }else {
            this.songName = songName;
            this.duration = duration;
            //System.out.println("The entered song is adding...");
        }

    }

    public String getSongName(){
        return this.songName;
    }

    public double getDuration(){
        return this.duration;
    }

}
