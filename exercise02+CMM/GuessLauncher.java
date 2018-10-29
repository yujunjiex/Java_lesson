import java.util.Scanner;
import java.util.Random;

class Player {
	public String name;
	public int number;
	public int scores=0;
	public String[] result={"你赢了","你输了"};
	
	public void guess(int num) {
		number = num;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setNumber(int num) {
		number=num;
	}
	public void scoresChange(boolean isWin) {
		if(isWin)
			scores++;
		else if(!isWin && scores!=0)
			scores--;
	}
	public String printResult(int num) {
		if(number==num)
			return result[0];
		else
			return result[1];
	}
}

class GuessGame{
	public Player player1=new Player();
	public Player player2=new Player();
	public Player player3=new Player();
	
	public void startGame() {
		System.out.println("-------------- 欢迎来到Guess Game --------------");
		Scanner sc = new Scanner(System.in);
		System.out.printf("输入第一名玩家的名字:");
		String name = sc.nextLine();
		player1.setName(name);
		System.out.printf("输入第二名玩家的名字:");
		name = sc.nextLine();
		player2.setName(name);
		System.out.printf("输入第三名玩家的名字:");
		name = sc.nextLine();
		player3.setName(name);
		
		System.out.println("设置想要进行的局数:");
		int matches = sc.nextInt();
		int match =1;
		while(matches>0)
		{		
			System.out.println();
			System.out.printf("第%d局游戏开始:\n",match++);
			Random rand = new Random();
			int gameNum = rand.nextInt(10);

			System.out.printf("%s请输入您猜想的数:",player1.name);
			int num = sc.nextInt();
			player1.setNumber(num);
			System.out.printf("%s请输入您猜想的数:",player2.name);
			num = sc.nextInt();
			player2.setNumber(num);
			System.out.printf("%s请输入您猜想的数:",player3.name);
			num = sc.nextInt();
			player3.setNumber(num);
			
			player1.scoresChange(player1.number==gameNum);
			player2.scoresChange(player2.number==gameNum);
			player3.scoresChange(player3.number==gameNum);
			System.out.printf("游戏结果为:随机数字为%d\n",gameNum);
			
			System.out.printf("%s:"+player1.printResult(gameNum)+" 剩余积分:%d\n",player1.name,player1.scores);
			System.out.printf("%s:"+player2.printResult(gameNum)+" 剩余积分:%d\n",player2.name,player2.scores);
			System.out.printf("%s:"+player3.printResult(gameNum)+" 剩余积分:%d\n",player3.name,player3.scores);
			
			matches--;
		}
		System.out.println("--------------- 游戏结束 --------------------");
		System.out.println("最终游戏结果:"+player1.name+": "+player1.scores+"分");
		System.out.println("       "+player2.name+": "+player2.scores+"分");
		System.out.println("       "+player3.name+": "+player3.scores+"分");
		System.out.printf("是否继续游戏?(y or n):");
		//nextLine()放在extInt()代码段后面会读入"\n",会自动接收上一个"\n"并跳过nextLine()的输入等待
		String over = sc.next();
		if(over.equals("y") || over.equals("Y"))
			startGame();
		//else防止子递归结束语句入栈
		else
			System.out.println("-------------- Thanks for playing~ ---------------------");
	}
}



public class GuessLauncher{
	public static void main(String[] args) {
		GuessGame game = new GuessGame();
		game.startGame();
	}
}