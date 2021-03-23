package SelfStudy.temporary;

/*
 * 실습) 정수 배열에서 key값을 찾아 위치(인덱스) 출력(순차검색)
 * 조건) 순차검색 메소드 작성해서 활용
 * 형식) static int search(int[] arr, int key);
 *
 * {3, 5, 7, 9, 1}
 *
 * key = 9
 * 위치 = 3
 *
 * key = 6
 * 위치 = -1
 */
public class aaa {

    static int search(int arr[], int key) {
        int i;

        for (i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7, 9};
        int key = 5;

        System.out.println(search(a, key));

    }


}
