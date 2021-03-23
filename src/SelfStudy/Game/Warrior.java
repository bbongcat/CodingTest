package SelfStudy.Game;

public class Warrior extends Adventurer {

    int str;

    public Warrior(String name) {
        this.name = name;
        this.hp = 80;
        this.level = 1;
        this.str = 1;
    }

    @Override
    void info() {
        super.info();
        System.out.println("# str: " + this.str);
    }

    void slash(Adventurer... adv) {

        if (adv.length > 0) {
            System.out.println(this.name + "님이 slash 사용!");
            System.out.println("-----------------------------");

            for (Adventurer ad : adv) {

                if (ad == this) continue;

                // 데미지 15 ~ 20
                int skillDamage = (int) (Math.random() * 11) + 15;

                ad.hp -= skillDamage;
                System.out.printf("%s님이 %d의 피해를 입었습니다. (남은 체력: %d)\n"
                        , ad.name, skillDamage, ad.hp);
            }
        } else {
            System.out.println("타겟이 없어 스킬이 사용되지 않았습니다.");
        }


    }
}