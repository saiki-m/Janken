package multiJanken;

import java.util.ArrayList;
import java.util.List;

/**
 * ジャンケンの審判を表すクラス。
 */
public class Judge{
	
	//じゃんけん回数
	private final int count = 2;
	
	/**
	 * ジャンケンを開始する。
	 * 
	 * @param player1: 判定対象プレイヤー1
	 * @param player2: 判定対象プレイヤー2
	 */
	public void startJanken(List<Player> players) {
		
		//ジャンケンの開始を宣言する。
		System.out.println("【ジャンケン開始】\n");
		
		//ジャンケンを3回行う
		for(int i = 0; i < count; i++) {
			
			//何回戦目か表示する
			System.out.printf("【%d回戦目】\n", (i + 1) );
			
			Player winner = judgeJanken(players);
			
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
		
		Player finalWinner = judgeFinalWinner(players);
		
		if(finalWinner != null) {
			
			//勝者を表示する
			System.out.println(players.get(0).getWinCount() + "対" + players.get(1).getWinCount() 
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
	private Player judgeJanken(List<Player> player) {
		
		List<Integer> playerHand = new ArrayList<Integer>();
		
		playerHand.add(player.get(0).showHand());
		
		for(int i = 1; i < player.size(); i++) {
			
			System.out.printf(" vs. ");

			playerHand.add(player.get(i).showHand());
		}
		
		
		for(int i = 1; i < player.size(); i++) {
			
			
		
		}
		
		//勝者を判定する
		if(    (playerHand.get(0) == Janken.STONE	&& playerHand.get(1) == Janken.SCISSORS)
				|| (playerHand.get(0) == Janken.SCISSORS	&& playerHand.get(1) == Janken.PAPER) 
				|| (playerHand.get(0) == Janken.PAPER	&& playerHand.get(1) == Janken.STONE)){
			
			return player.get(0);		//プレイヤー1の勝利
		}
		else if(    (playerHand.get(0) == Janken.STONE	&& playerHand.get(1) == Janken.PAPER)
			|| (	 playerHand.get(0) == Janken.SCISSORS	&& playerHand.get(1) == Janken.STONE) 
			|| (	 playerHand.get(0) == Janken.PAPER		&& playerHand.get(1) == Janken.SCISSORS)){
			
			return player.get(1);		//プレイヤー2の勝利
		}
		else {
				
			return null;	//引き分け
		}
		
		
		
	}
	
	/**
	 * ジャンケンの最終的な勝者を判定する
	 * 
	 * @param players: 全てのプレイヤー
	 * @return: 勝利数が最も多いプレイヤークラスのインスタンス。同率1位がいて引き分けの場合はnull。
	 */
	private Player judgeFinalWinner(List<Player> players) {
		
		//最終的な勝者の位置
		int finalWinnerIndex = 0;
				
		for(int i = 1; i < players.size(); i++) {
			
			//暫定一位の勝利数を上回る場合
			if(players.get(i).getWinCount() > players.get(0).getWinCount()) {
				
				finalWinnerIndex = i;
			}
		}	
		
		
		for(int i = 0; i < players.size(); i++) {
		
			if(i == finalWinnerIndex) {
				//暫定1位のときはスキップ
				continue;
			}
			else if(players.get(finalWinnerIndex).getWinCount() == players.get(i).getWinCount()) {
				//同率1位がいる時、引き分け。
				return null;
			}
		}
		
		//最終的な唯一の勝者
		return players.get(finalWinnerIndex);
	}
}
