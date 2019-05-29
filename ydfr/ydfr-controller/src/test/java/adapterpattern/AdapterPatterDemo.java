package adapterpattern;

public class AdapterPatterDemo {
	public static void main(String[] args) {
		AudioPlayer audioPlayer=new AudioPlayer();
		audioPlayer.play("mp3", "abc.mp3");
		audioPlayer.play("mp4", "def.mp4");
		audioPlayer.play("vlc", "vlc");
	}

}
