package kadai11_2;
import java.util.*;

public class Battle {
    public static void main(String[] args) {
        // モンスターをリストに格納
        List<Pokemon> monsters = new ArrayList<>();
        
        Monster_1 monster1 = new Monster_1();
        monster1.setName("サンダース");
        monster1.setHp(50);
        monster1.setAtk(8);
        monster1.setDfn(5);
        monster1.setSpd(10); 
        monster1.setType("でんき");
        monsters.add(monster1);  // リストに追加
        monster1.setMoves(Arrays.asList("たいあたり", "かみなり", "まるくなる"));

        Monster_2 monster2 = new Monster_2();
        monster2.setName("ブースター");
        monster2.setHp(50);
        monster2.setAtk(9);
        monster2.setDfn(5);
        monster2.setSpd(7); 
        monster2.setType("ほのお");
        monsters.add(monster2);  // リストに追加
        monster2.setMoves(Arrays.asList("たいあたり", "だいもんじ", "まるくなる"));

        Monster_3 monster3 = new Monster_3();
        monster3.setName("ヒートロトム");
        monster3.setHp(50);
        monster3.setAtk(10);
        monster3.setDfn(3);
        monster3.setSpd(11); 
        monster3.setType("でんき、ほのお");
        monsters.add(monster3);  // リストに追加
        monster3.setMoves(Arrays.asList("たいあたり", "だいもんじ","かみなり", "まるくなる"));

     

     // ユーザーの選択に応じたバトル処理
        Scanner scanner = new Scanner(System.in);
        System.out.print("戦うポケモンを選んでください (1): ");
        int choice1 = scanner.nextInt();
        System.out.print("戦うポケモンを選んでください (2): ");
        int choice2 = scanner.nextInt();

        Pokemon p1 = monsters.get(choice1 - 1); //0,1,2から選択
        Pokemon p2 = monsters.get(choice2 - 1);

        System.out.println("バトル開始！");

        // ターン制バトル
        while (p1.isAlive() && p2.isAlive()) {
            // p1 のターン
            p1.randomMove(p2);

            // 敵のHPチェック
            if (!p2.isAlive()) {
                System.out.println(p2.getName() + "は倒れた！");
                System.out.println(p1.getName() + "の勝利！");
                break;
            }

            // p2 のターン
            p2.randomMove(p1);

            // プレイヤーのHPチェック
            if (!p1.isAlive()) {
                System.out.println(p1.getName() + "は倒れた！");
                System.out.println(p2.getName() + "の勝利！");
                break;
            }
        }

        scanner.close();
    }
}
