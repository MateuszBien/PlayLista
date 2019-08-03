import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlista implements Playable {

    /*
    Głowna lata interejsu
    Java sprawdza czy do listy wrzucamy klase, ktora bedzie  implenetowacła dane interfejsu:
    czy klasa bedzie miala implenetacje metody play()
     */
    private List<Playable> tracks= new ArrayList<>();

    private PlayMode playMode;

    public PlayMode getPlayMode(){
        return playMode;
    }
    public void setPlayMode(PlayMode playMode){
        this.playMode = playMode;
    }
    public Playlista(){
        playMode = PlayMode.SEQUENTIALLY;
    }

    public void add(Playable playable) {
        tracks.add(playable);
    }
    @Override
    public void play(){
        switch (playMode){

            case SEQUENTIALLY:
                playSequentially();
                break;

            case RANDOMLY:
                playRandomly();
                break;

            case LOOP:
                playLoop();
                break;
        }
    }

        public void playSequentially(){
            for (Playable track : tracks){
                track.play();
            }

        }
        public void playRandomly(){
            List<Playable> playlisttoplay = new ArrayList<>(tracks);
            Collections.shuffle(playlisttoplay);
            for (Playable playable : playlisttoplay) {
                playable.play();
            }
        }

        public void playLoop(){
            int max =10;
            for (int i = 0; i <max; i++){
                playSequentially();
            }
        }

    public static void main(String[] args) {
        Playlista playlista = new Playlista();
        playlista.add(new Movie("Casablanca"));
        playlista.add(new Movie("Poranek kojota"));
        playlista.add(new Movie("Czarnoyl"));
        playlista.add(new Song("Brown Sugar", "Rolling Stones"));

        Playlista playlistSecond = new Playlista();

        playlistSecond.add(new Movie("Killer"));
        playlistSecond.add(new Movie("ZByszek"));
        playlistSecond.add(new Song("Slada kaszance","xyz"));



        playlista.add(playlistSecond);
        System.out.println(PlayMode.RANDOMLY);

        playlista.play();



    }
}
