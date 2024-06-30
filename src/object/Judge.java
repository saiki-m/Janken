package object;

/**
 * ジャンケンの審判を表すクラス。
 */
public class Judge {
	
	//じゃんけん回数
	private final int count = 50;
	
	/**
	 * ジャンケンを開始する。
	 * 
	 * @param player1: 判定対象プレイヤー1
	 * @param player2: 判定対象プレイヤー2
	 */
	
	
	
	public void startJanken(Player player1, Player player2) {
		
		//ジャンケンの開始を宣言する。
		System.out.println("【ジャンケン開始】\n");
		
		//ジャンケンを3回行う
		for(int i = 0; i < count; i++) {
			
			//何回戦目か表示する
			System.out.printf("【%d回戦目】\n", (i + 1) );
			
			Player winner = judgeJanken(player1, player2);
			
			if(winner != null) {
				
				//勝者を表示する
				System.out.println("\n" + winner.getName() + "が勝ちました！\n" );
				
				//勝ったプレイヤーへ結果を伝える
				winner.notifyResult();			
			}
			else {
				
				System.out.println("\n引き分けです！\n" );
			}
		}
		
		System.out.println("【ジャンケン終了】\n");
		
		Player finalWinner = judgeFinalWinner(player1, player2);
		
		if(finalWinner != null) {
			
			//勝者を表示する
			System.out.println(player1.getWinCount() + "対" + player2.getWinCount() 
					+ "で" + finalWinner.getName() + "が勝ちました！\n" );
		}
		else {
			
			System.out.println("\n引き分けです！\n" );
		}
	}
	
	/**
	 * ジャンケンを行って判定する。
	 * 
	 * @param player1: 判定対象プレイヤー1
	 * @param player2: 判定対象プレイヤー2
	 * @return: 勝ったプレイヤーのインスタンス。引き分けの場合はnull。
	 */
	private Player judgeJanken(Player player1, Player player2) {
		
		//プレイヤー1の手を出す
		int player1Hand = player1.showHand();
		
		System.out.print(" vs. ");
		
		//プレイヤー2の手を出す
		int player2Hand = player2.showHand();
		
		//勝者を判定する
		if(    (player1Hand == janken.STONE	&& player2Hand == janken.SCISSORS)
				|| (player1Hand == janken.SCISSORS	&& player2Hand == janken.PAPER) 
				|| (player1Hand == janken.PAPER	&& player2Hand == janken.STONE)){
			
			return player1;		//プレイヤー1の勝利
		}
		else if(    (player1Hand == janken.STONE	&& player2Hand == janken.PAPER)
			|| (	 player1Hand == janken.SCISSORS	&& player2Hand == janken.STONE) 
			|| (	 player1Hand == janken.PAPER		&& player2Hand == janken.SCISSORS)){
			
			return player2;		//プレイヤー2の勝利
		}
		else {
				
			return null;	//引き分け
		}
		
	}
	
	/**
	 * ジャンケンの最終的な勝者を判定する
	 * 
	 * @param player1: 判定対象プレイヤー1
	 * @param player2: 判定対象プレイヤー2
	 * @return: 勝ったプレイヤーのインスタンス。引き分けの場合はnull。
	 */
	private Player judgeFinalWinner(Player player1, Player player2) {
		
		//Player1から勝ち数を聞く
		int player1WinCount = player1.getWinCount();
		
		//Player2から勝ち数を聞く
		int player2WinCount = player2.getWinCount();
				
		//勝者を判定する
		if (player1WinCount > player2WinCount) {
			
			return player1;		//プレイヤー1の勝利
			
		}
		else if (player1WinCount < player2WinCount) {
			
			return player2;		//プレイヤー2の勝利
		}
		else{
			
			return null;	//引き分け
		}
	}
}
