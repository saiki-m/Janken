package noObject;

/**
 * オブジェクト指向課題
 * Work2-2
 * リスト2-1～リスト2-8を1つのJavaプログラムとしてまとめ、
 * ジャンケンプログラムを完成させてください。
 * プログラムは「SimpleJanken.java」というファイル名で保存してください。
 * 
 * 解答者 テー・ピー・エスサービス株式会社　齊木
 * 
 * 
 * 
 */
public class SimpleJanken3 {
	
	final int STONE = 0;	//グー
	final int SCISSORS = 1;	//チョキ
	final int PAPER = 2;	//パー
	
	int player1Hand = 0;
	
	int player2Hand = 0;
	
	//プレイヤー1の勝ち数
	int player1WinCount = 0;
	
	//プレイヤー2の勝ち数
	int player2WinCount = 0;
	
	public static void main(String[] args) {
		
		System.out.println("【ジャンケン開始】\n");
		System.out.println("【1回戦目】");
	}
	
	public int choiceHandLogic() {
		
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
	
	public void judgeWin(int myHand, int opponentHand, int playerWinCount) {
		
		if(    (myHand == STONE	&& opponentHand == SCISSORS)
			|| (myHand == SCISSORS	&& opponentHand == PAPER) 
			|| (myHand == PAPER	&& opponentHand == STONE))
		{
			
			playerWinCount++;
			System.out.println("勝ちました！");
			
		}
	}
}
