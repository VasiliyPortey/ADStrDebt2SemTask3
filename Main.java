import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int arrLength = sc.nextInt();
        ArrayList<Integer> numbersArrayList = new ArrayList<>();
        for (int i = 0; i < arrLength; i++)
            numbersArrayList.add(new Integer(randomEntering(-10,10)));
        System.out.println("Введите максимально допустимое различие: ");
        int difference = sc.nextInt();
        System.out.println("Получившийся массив: ".concat(numbersArrayList.toString()));
        System.out.println("Последняя (!) из наибольших невозрастающих последовательностей с различием "
                .concat(String.valueOf(difference)).concat(": ").concat(longestSequence(numbersArrayList, difference).toString()));
    }

    private static int randomEntering(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static ArrayList<Integer> longestSequence(ArrayList<Integer> numsArr, int difference){
        ArrayList<Integer> oldResultArray = new ArrayList<>();
        ArrayList<Integer> endResultArray = new ArrayList<>();
        endResultArray.add(numsArr.get(0));
        int index = 1;
        while (index<numsArr.size()){
            if (numsArr.get(index)<=numsArr.get(index-1)&&Math.abs(numsArr.get(index)-numsArr.get(index-1))<=difference) {
                endResultArray.add(numsArr.get(index));
                index++;
            }
            else {
                if (endResultArray.size()>=oldResultArray.size()||Math.abs(numsArr.get(index)-numsArr.get(index-1))>difference) {
                    if (endResultArray.size() >= oldResultArray.size()) {
                        oldResultArray.clear();
                        oldResultArray.addAll(endResultArray);
                    }
                }
                endResultArray.clear();
                endResultArray.add(numsArr.get(index));
                index++;
                }
            }
        return oldResultArray;
    }
}