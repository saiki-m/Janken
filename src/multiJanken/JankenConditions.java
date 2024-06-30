package multiJanken;

import java.util.List;

public class JankenConditions {
	
	
	/**
	 * 出した手が全員同じかどうか確認する
	 * 
	 * @param playerHands	参加者全員が出したジャンケンの手の値
	 * @return				全員同じであればtrue、そうでなければfalse
	 */
	public boolean allSameHand(List<Integer> playerHands) {
		
		for (Integer Hand : playerHands) {
			
	        if (!Hand.equals(playerHands.get(0))) {
	        	
	        	return false;
	        }
	    }

		return true;
	}
}
