package kadai11_2;

import java.util.*;

public class Monster_3 implements Pokemon,ThunderPokemon,FirePokemon{
	private String name;
	private int hp;
	private int atk;
	private int dfn;
	private int spd;
	private String type;
	List<String> moves=new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	public int getDfn() {
		return dfn;
	}
	public void setDfn(int dfn) {
		this.dfn = dfn;
	}
	
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public void setMoves(List<String> moves) {
	    this.moves = moves != null ? moves : new ArrayList<>(); // nullなら空リストを代入
	}
	
	// 技の共通処理
    private void performMove(String moveName, Pokemon opponent, int baseDamage, int accuracy, boolean isSpecialMove) {
        Random random = new Random();
        int hitChance = random.nextInt(100);

        if (hitChance < accuracy) { // 命中した場合
            int damage = Math.max(1, baseDamage - opponent.getDfn());
            if (isSpecialMove) {
                damage += this.atk; // 特殊技なら攻撃力を加算
            }
            System.out.println(this.name + "の" + moveName + "！ " + opponent.getName() + "に" + damage + "のダメージ！");
            opponent.setHp(opponent.getHp() - damage);
        } else { // 外した場合
            System.out.println(this.name + "の" + moveName + "！ しかし外れた！");
        }
    }

    // 各技の実装
    public void Attack(Pokemon opponent) { // たいあたり
        performMove("たいあたり", opponent, this.atk, 100, false);
    }

    public void ThunderAttack(Pokemon opponent) { // かみなり
        performMove("かみなり", opponent, this.atk * 2, 70, true);
    }
    public void FireAttack(Pokemon opponent) { // だいもんじ
        performMove("だいもんじ", opponent, this.atk * 2, 70, true);
    }

    public void Defense() { // まるくなる
        this.dfn += 2;
        if (this.dfn >= 12) {
            this.dfn = 12;
            System.out.println(this.name + "のまるくなる！ これ以上防御は上がらない！");
        } else {
            System.out.println(this.name + "のまるくなる！ 防御力が2上がった！");
        }
    }

    // ランダム技選択
    public void randomMove(Pokemon opponent) {
        Random random = new Random();
        String selectedMove = moves.get(random.nextInt(moves.size()));

        switch (selectedMove) {
            case "たいあたり":
                Attack(opponent);
                break;
            case "かみなり":
                ThunderAttack(opponent);
                break;
            case "まるくなる":
            	Defense();
                break;
            case"だいもんじ":
            	FireAttack(opponent);
            default:
                System.out.println(this.name + "は何もしなかった！");
                break;
        }
    }
	
	public boolean isAlive() {
	    return this.hp > 0;
	}


}
