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
public class SimpleJanken {
	
	final static int STONE = 0;	//グー
	final static int SCISSORS = 1;	//チョキ
	final static int PAPER = 2;	//パー
	
	static int myHand = 0;
	
	static int opponentHand = 0;
	
	//勝負する回数
	final static int playNumber = 3; 
	
	//プレイヤー1の勝ち数
	static int myWinCount = 0;
	
	
	public static void main(String[] args) {
		
		System.out.println("【ジャンケン開始】\n");
		System.out.println("【1回戦目】");
		
		for(int i = 1; i <= playNumber; i++) {
			
			myHand = choiceHandLogic();
			opponentHand = choiceHandLogic();
			
			judgeHand(myHand, opponentHand);
		}
		
		decideWinner();
	}
	
	public static int choiceHandLogic() {
		
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
	
	public static void judgeHand(int myHand, int opponentHand) {
		
		if(    (myHand == STONE	&& opponentHand == SCISSORS)
			|| (myHand == SCISSORS	&& opponentHand == PAPER) 
			|| (myHand == PAPER	&& opponentHand == STONE))
		{
			myWinCount++;
			System.out.println("勝ちました！");
		}
		else if(myHand == opponentHand) {
			System.out.println("引き分けです。");
		}
		else {
			System.out.println("負けました。");
		}
	}
	
	public static void decideWinner() {
		
		if(myWinCount > (playNumber - myWinCount) ) {
			System.out.println(myWinCount + "対" + (playNumber - myWinCount) + "であなたの勝ちです！ \n");
		}
		else if(myWinCount == (playNumber - myWinCount) ){
			System.out.println(myWinCount + "対" + (playNumber - myWinCount) + "で引き分けです！ \n");
		}
		else {
			System.out.println(myWinCount + "対" + (playNumber - myWinCount) + "で相手の勝ちです！ \n");
		}
	}
}
