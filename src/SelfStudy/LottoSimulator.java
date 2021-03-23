package SelfStudy;

import java.util.*;

public class LottoSimulator {

    public static Scanner sc = new Scanner(System.in);
    static int prize1 = 0; //1등 당첨횟수를 저장할 변수.
    static int prize2 = 0; //2등 당첨횟수를 저장할 변수.
    static int prize3 = 0; //3등 당첨횟수를 저장할 변수.
    static int prize4 = 0; //4등 당첨횟수를 저장할 변수.
    static int prize5 = 0; //5등 당첨횟수를 저장할 변수.
    static int failCnt = 0;//꽝 당첨횟수를 저장할 변수.

    // 로또 당첨 번호 6개 랜덤 생성 메서드
    public static List<Integer> createLotto() {
        List<Integer> lotto = new ArrayList<>();
        while (true) {
            int randomNumber = (int) (Math.random() * 45) + 1;

            if (lotto.size() == 6) {
                break;
            }

            if (!lotto.contains(randomNumber)) {
                lotto.add(randomNumber);
            }
        }
        lotto.sort(Integer::compareTo);
        return lotto;
    }

    // 보너스 번호 생성
    public static int createBonus(List<Integer> win) {


        while (true) {
            int randomNumber = (int) (Math.random() * 45) + 1;

            if (win.contains(randomNumber)) {
                continue;
            } else {
                return randomNumber;
            }
        }

    }

    // 로또 번호 체크
    private static void checkLottoNumber(List<Integer> win, List<Integer> myLotto, int bonus) {

        int cnt = 0;

        for (int i : myLotto) {
            if (win.contains(i)) {
                cnt++;
            }
        }

        if (cnt == 6) {
            prize1++;
        } else if (cnt == 5) {
            if (win.contains(bonus)) {
                prize2++;
            } else {
                prize3++;
            }
        } else if (cnt == 4) {
            prize4++;
        } else if (cnt == 3) {
            prize5++;
        } else {
            failCnt++;
        }
    }


    public static void main(String[] args) {
        List<Integer> win = createLotto();
        int bonus = createBonus(win);
        int paper = 0;
        while (true) {
            List<Integer> myLotto = createLotto();
            paper++;
            checkLottoNumber(win, myLotto, bonus);

            if (prize1 == 1) {
                long lottoPrizeMoney = (prize1 * 2000000000L) + (prize2 * 60000000L)
                        + (prize3 * 1500000L) + (prize4 * 50000L) + (prize5 * 5000L);
                long lottoPurchaseMoney = paper * 1000L;
                System.out.printf("\n# 축하합니다! %d번만에 1등에 당첨되었습니다.\n", paper);
                System.out.printf("# 당첨 번호: %s, bonus: [%d]\n", win, bonus);
                System.out.println("# 1등에 당첨될때까지 누적 당첨현황. . .");
                System.out.printf("# 1등 당첨횟수(%.8f%%): %d회\n", (prize1 / (double) paper) * 100, prize1);
                System.out.printf("# 2등 당첨횟수(%.8f%%): %d회\n", (prize2 / (double) paper) * 100, prize2);
                System.out.printf("# 3등 당첨횟수(%.8f%%): %d회\n", (prize3 / (double) paper) * 100, prize3);
                System.out.printf("# 4등 당첨횟수(%.8f%%): %d회\n", (prize4 / (double) paper) * 100, prize4);
                System.out.printf("# 5등 당첨횟수(%.8f%%): %d회\n", (prize5 / (double) paper) * 100, prize5);
                System.out.printf("# 꽝 당첨 횟수(%.8f%%): %d회\n\n", (failCnt / (double) paper) * 100, failCnt);
                System.out.printf("# 총 당첨금: %d원\n", lottoPrizeMoney);
                System.out.printf("# 총 로또 구매 금액: %d원\n", lottoPurchaseMoney);
                System.out.println("# 이득 계산: " + (lottoPrizeMoney - lottoPurchaseMoney) + "원");
                break;
            } else {
                System.out.printf("로또 %d장째 구입중. . .\n", paper);
            }
        }
    }


}