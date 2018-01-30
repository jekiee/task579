package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        int positiveCount = 0;
        int negativeCount = 0;
        int positiveSum = 0;
        int negativeSum = 0;
        ArrayList<Integer> positiveNumIndexes = new ArrayList<>();
        ArrayList<Integer> negativeNumIndexes = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("INPUT.TXT")));
        int arraySize = Integer.parseInt(bufferedReader.readLine());
        String[] stringArray = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
            if (array[i] >= 0) {
                positiveCount++;
                positiveSum = positiveSum + array[i];
                positiveNumIndexes.add(i + 1);
            } else {
                negativeCount++;
                negativeSum = negativeSum + Math.abs(array[i]);
                negativeNumIndexes.add(i + 1);
            }
        }

        String[] result = positiveSum >= negativeSum
            ? getResult(positiveCount, positiveNumIndexes)
            : getResult(negativeCount, negativeNumIndexes);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OUTPUT.TXT")));
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);
            if (i < result.length) {
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close();
    }

    private static String[] getResult(int count, ArrayList<Integer> indexes) {
        String[] string = new String[2];
        string[0] = String.valueOf(count);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : indexes) {
            stringBuilder.append(integer).append(' ');
        }

        string[1] = stringBuilder.toString();
        return string;
    }
}
