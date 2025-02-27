package multiJanken;

import java.util.List;

public class JankenConditions {
	
	
	/**
	 * 出した手が全員同じかどうか確認する
	 * 
	 * @param playerHands	参加者全員が出したジャンケンの手の値
	 * @return				全員同じであればtrue、そうでなければfalse
	 */
	public static boolean allSameHand(List<Integer> playerHands) {
		
		for (Integer Hand : playerHands) {
			
	        if (!Hand.equals(playerHands.get(0))) {
	        	//System.out.println("aaa");
	        	return false;
	        }
	    }

		return true;
	}
	
	
	/**
	 * allSameHandメソッドを参考にコーディング
	 * 自分の手以外の２種類の手が、それぞれ1つ以上ある
	 * 
	 * @param playerHands	参加者全員が出したジャンケンの手の値
	 * @return				自分の手以外の２種類の手が、それぞれ1つ以上あればtrue
	 */
	public static boolean differentHands(List<Integer> playerHands) {
		
		boolean flag1 = false;
		boolean flag2 = false;
		
		
		for (Integer Hand : playerHands) {
			
	        if (Hand.equals( (playerHands.get(0) + 1) % Janken.HandkindNumber ) ) {
	        	
	        	flag1 = true;	//1種類の違う手が見つかったためtrue
	        }
	        else if (Hand.equals( (playerHands.get(0) + 2) % Janken.HandkindNumber ) ) {
	        	
	        	flag2 = true;
	        }
	        
	        if(flag1 && flag2) {
	        
	        	return true;
	        }
	    }

		return false;
	}
	
	
	/**
	 * 
	 * 対戦相手の手の中で、自分が負ける手が1つも出てない
	 * 
	 * @param playerHands	参加者全員が出したジャンケンの手の値
	 * @return				対戦相手の手の中で、自分が負ける手が1つも出ていなければtrue
	 */
	public static boolean myHandDontLose(List<Integer> playerHands, int index) {
		
		int myHand = playerHands.get(index);
		
		for(int i = 0; i < playerHands.size(); i++) {
			
			if(i == index) {
				
				continue;
			}
			else if (playerHands.get(i).equals( (myHand + 2) % Janken.HandkindNumber ) ) {
		
				return false;
			}
			else {
				
			}
		}
		
		return true;
	}
	/**
	 * 
	 * 対戦相手の手の中で、自分が勝利できる手が1つ以上出ている
	 * 
	 * @param playerHands	参加者全員が出したジャンケンの手の値
	 * @return				対戦相手の手の中で、自分が勝利できる手が1つ以上出ていればtrue
	 */
	public static boolean DefeatOpponentHand(List<Integer> playerHands, int index) {
		
		int myHand = playerHands.get(index);
				
		for(int i = 0; i < playerHands.size(); i++) {
			
			if(i == index) {
				continue;
			}
			else if (playerHands.get(i).equals( (myHand + 1) % Janken.HandkindNumber ) ) {
				return true;
			}
		}

		return false;
	
	}
}
