// Interface for the universal audio player
interface AudioPlayer {
    void playAudio();
}

// MP3 player, one of the existing audio sources
class MP3Player implements AudioPlayer {
    @Override
    public void playAudio() {
        System.out.println("Playing MP3 audio...");
    }
}

// CD player, another existing audio source
class CDPlayer implements AudioPlayer {
    @Override
    public void playAudio() {
        System.out.println("Playing CD audio...");
    }
}

// VinylRecordPlayer, the new audio source with a different interface
class VinylRecordPlayer {
    public void playVinyl() {
        System.out.println("Playing vinyl record...");
    }
}

// Adapter class to make VinylRecordPlayer compatible with AudioPlayer
class VinylRecordAdapter implements AudioPlayer {
    public VinylRecordPlayer vinylPlayer;   // Dependency 1: VinylRecordPlayer

    public VinylRecordAdapter(VinylRecordPlayer vinylPlayer) {
        this.vinylPlayer = vinylPlayer;
    }

    @Override
    public void playAudio() {
        vinylPlayer.playVinyl();        // Adapter depends on VinylRecordPlayer
    }
}

// Client code using the universal audio player
public class Main {
    public static void main(String[] args) {
        AudioPlayer mp3Player = new MP3Player();
        AudioPlayer cdPlayer = new CDPlayer();

        // Integrate the VinylRecordPlayer using the adapter
        VinylRecordPlayer vinylPlayer = new VinylRecordPlayer();
        AudioPlayer vinylAdapter = new VinylRecordAdapter(vinylPlayer);

        // Use the universal audio player to play different sources
        mp3Player.playAudio();    // Dependency 2
        cdPlayer.playAudio();     // Dependency 2
        vinylAdapter.playAudio(); // This uses the adapter to play vinyl records
    }
}
