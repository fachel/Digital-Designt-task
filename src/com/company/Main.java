package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите строку");
        Scanner in = new Scanner(System.in);
	    String s_input = in.nextLine();
	    List<String> mas = Arrays.asList(s_input.split(""));
	    int i = 0;
	    while (true){
            if (mas.contains("[")) {
                if (!mas.get(i).equals("[") && !mas.get(i).matches("[a-zA-Z]")) {
                    int n = Integer.parseInt(mas.get(i));
                    int k = 0;
                    int end = 0;
                    for (int l = i + 2; l < mas.size(); l++) {
                        if (mas.get(l).equals("["))
                            k++;
                        else if (mas.get(l).equals("]")) {
                            if (k == 0) {
                                end = l;
                                break;
                            } else {
                                k--;
                            }
                        }
                    }
                    ArrayList<String> new_mas = new ArrayList();
                    for (int p = 0; p < n; p++)
                        for (int j = i + 2; j < end; j++)
                            new_mas.add(mas.get(j));
                    for (int j = end + 1; j < mas.size(); j++)
                        new_mas.add(mas.get(j));
                    List<String> subList = mas.subList(0, i);
                    if (subList.size() == 0) {
                        mas = new_mas;
                        i = 0;
                    }
                    else {
                        subList.addAll(new_mas);
                        mas = subList;
                        i = 0;
                    }
                }
                else
                    i ++;
            }
            else
                break;
        }
        String listString = String.join("", mas);
        System.out.println(listString);
    }
}
//3[xyz]4[xy]z = xyzxyzxyzxyxyxyxyz
//2[3[x]y]  = xxxyxxxy