package kadai11_2;

public interface  Pokemon {
	String getName();
    String getType();
    int getHp();
    int getSpd();
    void setName(String name);
    void setType(String type);
    void setHp(int hp);
    void Attack(Pokemon opponent);
    void Defense();
	int getDfn();
	boolean isAlive(); // HPが0かどうかの確認
	void randomMove(Pokemon p1);


}
