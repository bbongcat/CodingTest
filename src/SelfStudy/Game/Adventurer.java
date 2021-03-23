package SelfStudy.Game;

public class Adventurer {

    String name;
    int level;
    int hp;
    int skillPoint; //한 명 죽일 때마다 스킬포인트 1 추가. 새 스킬 배우면 1 차감.


    public Adventurer() {}

    public Adventurer(String name, int hp) {
        this.name = name;
        this.level = 1;
        this.hp = hp;
    }

    void info() {
        System.out.println("======= 캐릭터 정보 =======");
        System.out.println("# 이름: " + this.name);
        System.out.println("# 레벨: " + this.level);
        System.out.println("# 체력: " + this.hp);
    }

    void levelUp() {

    }

    void skillLevelUp() {

    }
}
