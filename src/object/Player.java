package object;

/**
 * ジャンケンするプレイヤーを定義するクラス
 */
public class Player {
	
	//プレイヤークラスの属性
	/** プレイヤーの名前 */
	
	
	private String name;	
	
	/** プレイヤーの勝った回数 */
	private int winCount = 0;
	

	/**
	 * 
	 *  プレイヤークラスのコンストラクタ。
	 * 
	 * @param name 名前
	 */
	public Player(String name) {
		this.name = name;
	}
	
	public Player() {
		this.name = "ゲストさん";
	}
	
	//プレイヤークラスの操作
	
	/**
	 * 
	 * ジャンケンの手を出す。
	 * 
	 * @return ジャンケンの手
	 */
	public int showHand() {
		
		int hand = janken.PAPER;	//パー
		
		//0以上3未満の小数として乱数を得る
		double randomNum = Math.random() * 3;
		
		if (randomNum < 1) {
			
			hand = janken.STONE;	//グー
			System.out.print("グー");	//randomNumが0.0以上1.0未満の場合、グー
		}
		else if (randomNum < 2) {
			
			hand = janken.SCISSORS;	//randomNumが1.0以上2.0未満の場合、チョキ
			System.out.print("チョキ");
		}
		else {
			
			System.out.print("パー");	//randomNumが2.0以上3.0未満の場合、パー
		}
		
		return hand;
	}
	
	/**
	 * 
	 * 審判から勝敗を聞く。
	 * 
	 * @param result true:勝ち  false:負け
	 */
	public void notifyResult() {
		winCount++;	
	}
	
	/**
	 *  自分の勝った回数を答える。
	 *  
	 * @return 勝った回数
	 */
	public int getWinCount() {
		return winCount;
	}

	/**
	 * 
	 *  自分の名前を答える。
	 * 
	 * @return 名前
	 */
	public String getName() {
		return name;
	}
	
}
