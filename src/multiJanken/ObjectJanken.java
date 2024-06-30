package multiJanken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ジャンケンプログラムを動作させるクラス
 * 
 * 
 */
public class ObjectJanken {

	public static void main(String[] args) {
		
		List<Player> players = new ArrayList<Player>
			(Arrays.asList(
				new Player("安藤さん"), new Player("山田さん")));
		
		//審判インスタンスを作成
		Judge tanaka = new Judge();
		
		//ジャンケンを開始する
		tanaka.startJanken(players);
		System.out.println(0%1);
	}

}