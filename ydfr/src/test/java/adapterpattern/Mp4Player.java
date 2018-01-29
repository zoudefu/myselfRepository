package adapterpattern;

public class Mp4Player implements AdvanceMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("播放MP4的文件文件名称"+fileName);

	}

}
