package object;

/**
 * ジャンケンプログラムを動作させるクラス
 * 
 * 
 */
public class ObjectJanken {

	public static void main(String[] args) {
		
		//審判をつくる
		Judge tanaka = new Judge();
		
		//プレイヤーをつくる
		Player murata = new Player("村田さん");
		Player yamada = new Player("山田さん");
		
		//ジャンケンを開始する
		tanaka.startJanken(murata, yamada);
	}

}
