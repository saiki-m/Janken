package noObject;

/**
 * オブジェクト指向課題
 * Work2-2 (オブジェクト指向で作られていません。次のWorkで作成します）
 * リスト2-1～リスト2-8を1つのJavaプログラムとしてまとめ、
 * ジャンケンプログラムを完成させてください。
 * プログラムは「SimpleJanken.java」というファイル名で保存してください。
 * 
 * 解答者 テー・ピー・エスサービス株式会社　齊木
 * 
 * 
 * 
 */
public class SimpleJanken0625 {
	
	final static int STONE = 0;	//グー
	final static int SCISSORS = 1;	//チョキ
	final static int PAPER = 2;	//パー
	
	//自分の最初の手の形
	static int player1Hand = 0;
	
	//相手の最初の手の形
	static int player2Hand = 0;
	
	//プレイヤー1の勝ち数
	static int player1WinCount = 0;
	
	//プレイヤー2の勝ち数
	static int player2WinCount = 0;
	
	//勝負する回数
	final static int playNumber = 3; 
	
	public static void main(String[] args) {
		
		System.out.println("【ジャンケン開始】\n");
		
		for(int i = 0; i < playNumber; i++) {
			
			System.out.printf("【%d回戦目】", (i + 1) );
			
			player1Hand = choiceHand();			
			System.out.print(" vs. ");
			player2Hand = choiceHand();
			
			judgeWin(player1Hand, player2Hand);
		}
		
		System.out.println("【ジャンケン終了】\n");
		
		decideWinner(player1WinCount, player2WinCount);
	}
	
	/**
	 *   グー、チョキ、パーの中から1つ選ぶ
	 * @return STONE、SCISSORS、PAPERに格納されている整数値
	 */
	public static int choiceHand() {
		
		int Hand = STONE;	//グー
		
		//0以上3未満の小数として乱数を得る
		double randomNum = Math.random() * 3;
		
		if (randomNum < 1) {
			
			System.out.print("グー");	//randomNumが0.0以上1.0未満の場合、グー
		}
		else if (randomNum < 2) {
			
			Hand = SCISSORS;	//randomNumが1.0以上2.0未満の場合、チョキ
			System.out.print("チョキ");
		}
		else if (randomNum < 3) {
			
			Hand = PAPER;	//randomNumが2.0以上3.0未満の場合、パー
			System.out.print("パー");
		}
		
		return Hand;
	}
	
	/**
	 * 1回ごとの勝負の勝敗を決めて勝利数を加算する。
	 * 
	 * @param player1Hand	自分の手
	 * @param player2Hand	相手の手
	 */
	public static void judgeWin(int player1Hand, int player2Hand) {
		
		if(    (player1Hand == STONE	&& player2Hand == SCISSORS)
			|| (player1Hand == SCISSORS	&& player2Hand == PAPER) 
			|| (player1Hand == PAPER	&& player2Hand == STONE))
		{
			
			player1WinCount++;
			System.out.println("\nプレイヤー1が勝ちました！\n");	
		}
		else if(    (player1Hand == STONE	&& player2Hand == PAPER)
			|| (	 player1Hand == SCISSORS	&& player2Hand == STONE) 
			|| (	 player1Hand == PAPER		&& player2Hand == SCISSORS))
		{
			
			player2WinCount++;
			System.out.println("\nプレイヤー2が勝ちました！\n");	
		}
		else {
			System.out.println(" \n引き分けです！\n");	
		}
	}
	
	/**
	 * @param player1WinCount	自分の勝利数
	 * @param player2WinCount	相手の勝利数
	 */
	public static void decideWinner(int player1WinCount, int player2WinCount){
		
		if (player1WinCount > player2WinCount) {
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー1の勝ちです！\n");
		}
		else if (player1WinCount < player2WinCount) {
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー2の勝ちです！\n");
		}
		else{
			System.out.println(player1WinCount + "対" + player2WinCount + "で引き分けです！\n");
		}
	}
}
