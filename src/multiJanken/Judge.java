package multiJanken;

import java.util.ArrayList;
import java.util.List;

/**
 * ジャンケンの審判を表すクラス。
 */
public class Judge{
	
	//じゃんけん回数
	private final int count = 5;
	
	/**
	 * ジャンケンを開始する。
	 * 
	 * @param player1: 判定対象プレイヤー1
	 * @param player2: 判定対象プレイヤー2
	 */
	public void startJanken(List<Player> players) {
		
		//ジャンケンの開始を宣言する。
		System.out.println("【ジャンケン開始】");
		
		//ジャンケンを3回行う
		for(int i = 0; i < count; i++) {
			
			//何回戦目か表示する
			System.out.printf("\n\n【%d回戦目】\n", (i + 1) );
			
			List<Integer> playerHand = new ArrayList<Integer>();
			
			for(int k = 0; k < players.size(); k++) {
				
				if(k >= 1) {
					
					System.out.printf(" vs. ");
				}

				playerHand.add(players.get(k).showHand());
			}
			
				for(int j = 0; j < players.size(); j++) {
					
					Player winner = judgeJanken(players, playerHand, j);
					
					if(winner != null) {
						
						//勝者を表示する
						System.out.println("\n" + winner.getName() + "が勝ちました！\n" );
						
						//勝ったプレイヤーへ結果を伝える
						winner.notifyResult();
					}
				
				
			}
		}
		
		System.out.println("\n\n【ジャンケン終了】\n");
		
		Player finalWinner = judgeFinalWinner(players);
		
		if(finalWinner != null) {
			
			System.out.print(players.get(0).getWinCount());
			
			for(int i = 1; i < players.size(); i++) {
				System.out.print("対" + players.get(i).getWinCount() );
			}
		
			System.out.println("で" + finalWinner.getName() + "が勝ちました！\n");
		}
		else {
			
			System.out.println("引き分けです！\n" );
		}
	}
	
	/**
	 * ジャンケンを行って判定する。
	 * 
	 * @param player1: 判定対象プレイヤー1
	 * @param player2: 判定対象プレイヤー2
	 * @return: 勝ったプレイヤーのインスタンス。引き分けの場合はnull。
	 */
	private Player judgeJanken(List<Player> players, List<Integer> playerHand, int j) {
		
		if(		JankenConditions.allSameHand(playerHand) ||
				JankenConditions.differentHands(playerHand)) {
			

			return null;	//引き分け
		}
		else if(JankenConditions.myHandDontLose(playerHand, j) &&
				JankenConditions.DefeatOpponentHand(playerHand, j)){
			
			return players.get(j);
		}
		
		return null;
		
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
