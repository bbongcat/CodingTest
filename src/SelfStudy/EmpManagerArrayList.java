package SelfStudy;

import java.util.*;

public class EmpManagerArrayList {

    static Scanner sc = new Scanner(System.in);

    static int count = 0;

    static List<String> empNumbers = new ArrayList<>();
    static List<String> names = new ArrayList<>();
    static List<String> ages = new ArrayList<>();
    static List<String> departments = new ArrayList<>();

    static void showMenu() {
        System.out.println("\n========= 사원 관리 프로그램 =========");
        System.out.println("# 1. 사원 정보 신규 등록");
        System.out.println("# 2. 모든 사원 정보 보기");
        System.out.println("# 3. 사원 정보 검색");
        System.out.println("# 4. 사원 정보 수정");
        System.out.println("# 5. 사원 정보 삭제");
        System.out.println("# 6. 프로그램 종료");
        System.out.println("=====================================");
    }

    static void exitProgram() {
        System.out.println("프로그램을 종료합니까? [y/n]");
        System.out.print("> ");
        String answer = sc.next();

        switch (answer) {
            case "y": case "Y": case "ㅛ":
                sc.close();
                System.exit(0);
            case "n": case "N": case "ㅜ":
                System.out.println("프로그램 종료를 취소합니다.");
                return;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
    }

    static void insertEmpData() {
        System.out.println("# 사원정보 등록을 시작합니다.");

        System.out.print("- 사번: ");
        String empNum = sc.next();

        System.out.print("- 이름: ");
        String name = sc.next();

        System.out.print("- 나이: ");
        String age = sc.next();

        System.out.print("- 부서: ");
        String dep = sc.next();

        empNumbers.add(empNum);
        names.add(name);
        ages.add(age);
        departments.add(dep);
        count++;

    }

    static void showEmpData() {
        if (count >= 1) {
            System.out.println("================ 전체 사원 정보 ================");
            System.out.println("사번          이름          나이          부서  ");
            System.out.println("==============================================");

            for (int i = 0; i < count; i++) {
                System.out.printf("%s         %s           %s세          %s\n"
                        , empNumbers.get(i), names.get(i), ages.get(i), departments.get(i));
            }
            System.out.println("==============================================");
        } else {
            System.out.println("등록된 사원 정보가 없습니다.");
        }
    }

    static void searchEmpData() {
        System.out.println("# 조회하실 사원의 번호를 입력하세요.");
        System.out.print("> ");
        String search = sc.next();

        for (int i = 0; i < count; i++) {
            if (empNumbers.get(i).equals(search)) {
                System.out.println("================ 조회된 사원 정보 ===============");
                System.out.println("사번          이름          나이          부서  ");
                System.out.println("==============================================");
                System.out.printf("%s         %s           %s세          %s\n"
                        , empNumbers.get(i), names.get(i), ages.get(i), departments.get(i));
                System.out.println("==============================================");
                return;
            }
        }
        System.out.println("조회하신 사원 정보는 존재하지 않습니다.");
    }

    static void modEmpData() {
        System.out.println("# 수정하실 사원의 번호를 입력하세요.");
        System.out.print("> ");
        String modSearch = sc.next();

        for (int i = 0; i < count; i++) {
            if (empNumbers.get(i).equals(modSearch)) {
                System.out.printf("%s님의 정보를 수정합니다.\n", names.get(i));
                System.out.println("[ 1. 나이 변경 | 2. 부서 변경 | 3. 취소]");
                System.out.print("> ");
                String modNum = sc.next();

                switch (modNum) {
                    case "1":
                        System.out.println("-변경하실 나이를 입력하세요.");
                        System.out.print("> ");
                        String modAge = sc.next();
                        System.out.printf("나이가 %s세에서 %s세로 변경되었습니다.\n", ages.get(i), modAge);
                        ages.set(i, modAge);
                        return;
                    case "2":
                        System.out.println("-변경하실 부서를 입력하세요.");
                        System.out.print("> ");
                        String modDep = sc.next();
                        System.out.printf("부서가 %s에서 %s로 변경되었습니다.\n", departments.get(i), modDep);
                        departments.set(i, modDep);
                        return;
                    case "3":
                        System.out.println("# 정보 수정을 취소합니다.");
                        return;
                }
            }
        }
        System.out.println("조회하신 사원 정보는 존재하지 않습니다.");
    }


    static void delEmpData() {
        System.out.println("# 삭제하실 사원의 번호를 입력하세요.");
        System.out.print("> ");
        String delSearch = sc.next();

        for (int i = 0; i < count; i++) {
            if (empNumbers.get(i).equals(delSearch)) {
                System.out.printf("# %s님의 정보를 삭제합니다. [y/n]\n", names.get(i));
                System.out.print("> ");
                String answer = sc.next();

                switch (answer) {
                    case "Y":
                    case "y":
                    case "ㅛ":
                        System.out.printf("# %s님의 정보가 정상적으로 삭제되었습니다.\n", names.get(i));

                        empNumbers.remove(i);
                        names.remove(i);
                        ages.remove(i);
                        departments.remove(i);

                        count--;
                        return;
                    case "N":
                    case "n":
                    case "ㅜ":
                        System.out.println("# 정보 삭제를 취소합니다.");
                        return;
                    default:
                        System.out.println("해당 번호는 존재하지 않습니다.");
                        return;
                }
            }
        }
    }



    public static void main(String[] args) {

        while (true) {
            showMenu();
            System.out.print("> ");
            int menuNum = sc.nextInt();

            if (menuNum == 1) {
                insertEmpData();
            } else if (menuNum == 2) {
                showEmpData();
            } else if (menuNum == 3) {
                searchEmpData();
            } else if (menuNum == 4) {
                modEmpData();
            } else if (menuNum == 5) {
                delEmpData();
            } else if (menuNum == 6) {
                exitProgram();
            } else {
                System.out.println("메뉴를 잘못 입력했습니다.");
            }
        }
    }


}