package adapterpattern;

public  class VlcPlayer implements AdvanceMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		System.out.println("播放vlc格式的文件 文件名"+fileName);

	}

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
	}

}
