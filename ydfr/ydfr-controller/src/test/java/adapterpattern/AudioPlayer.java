package adapterpattern;

public class AudioPlayer implements MediaPlayer {
    
	MediaAdapter mediaAdapter;
	@Override
	public void play(String audioType, String fileName) {
		//播放mp3 音乐文件的内置支持
		if(audioType.equalsIgnoreCase("mp3")){
			System.out.println("播放mp3文件 文件名称"+fileName);
		}
       //mediaAdapter提供了播放其他文件格式的支持
		else if(audioType.equalsIgnoreCase("vlc")||audioType.equalsIgnoreCase("mp4")){
			mediaAdapter=new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
	}

}
