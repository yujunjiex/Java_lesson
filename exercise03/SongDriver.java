/**  
* Title: SongDriver.java 
* Description:  一个简单的点歌台实现
* @author Yjj  
* @date 2018年10月7日 下午9:13:58
* @version 1.0  
*/

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Song{
	String songName;
	String singer;
	double time;
	public Song(String songName,String singer,double time) {
		this.songName=songName;
		this.singer=singer;
		this.time=time;
	}
	
}

class Master{
	static HashMap<Integer,Song> songList;
	public Master() {
		songList = new HashMap<Integer,Song>();
	}
	public boolean play() {
		if(songList.isEmpty())
			return false;
		else
			return true;	
	}
	public void show() {
		System.out.println("当前列表有"+songList.size()+"首歌:");
		for(int i=0;i<songList.size();i++) {
			double times = songList.get(i).time;
			int m = (int)times/60;
			int s = (int)times%60;
			System.out.println(i+1+"."+songList.get(i).songName+"-"+songList.get(i).singer+"  "+m+":"+s);
		}
	}
}

class Player{
	public boolean addSong(String songName,String singer,double time) {
		Song song = new Song(songName,singer,time);
		if(Master.songList.put(Master.songList.size(),song)!=null)//歌曲重复添加，返回false
			return true;
		return false;
	}
}

public class SongDriver {
	public static void main(String[] args) {
		SongDriver demo = new SongDriver();
		demo.show();
		
	}
	public Master master;
	public Player player;
	public SongDriver() {
		master = new Master();
		player = new Player();
	}
	public void show() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------- 欢迎来到点歌台 ---------------- ");
		while(true) {
			if(master.play()) {
				master.show();
				System.out.printf("输入1点歌，2切换到点歌台，3退出:");		
				while(true) {
					String num = sc.next();
					if(num.equals("1")) {
						System.out.printf("请添加:");
						String info = sc.nextLine();
						String[] splitInfo = info.split("\\s+");
						player.addSong(splitInfo[0], splitInfo[1], Double.parseDouble(splitInfo[2]));
						break;
					}
					if(num.equals("2"))	{
						System.out.printf("选择你要播放的歌曲序号:");
						int n = sc.nextInt();
						System.out.println(Master.songList.get(n-1).songName+"-"+Master.songList.get(n-1).singer+"正在播放~");
						
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						Master.songList.remove(n-1);
						System.out.println();
						System.out.printf("播放结束");
						
						break;					
					}
					if(num.equals("3"))
					{
						return;
					}
					else
					{
						System.out.print("输入有误，请重新输入:");
					}
				}
				
			}
			else {
				System.out.printf("当前列表暂无歌曲，请添加:");
				String info = sc.nextLine();
				String[] splitInfo = info.split("\\s+");
				player.addSong(splitInfo[0], splitInfo[1], Double.parseDouble(splitInfo[2]));
			}		
		}	
	}
}
