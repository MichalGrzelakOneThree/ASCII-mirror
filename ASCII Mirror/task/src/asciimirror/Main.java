package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String input = scanner.nextLine();
        List<String> list = new ArrayList<>();
        List<String> modifiedList = new ArrayList<>(list);
        File file = new File(input);

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                list.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        int longestString = 0;
        for (String a : list) {
            if (a.length() > longestString) {
                longestString = a.length();
            }
        }

        for (String s : list) {
            int difference = 0;
            StringBuilder sb = new StringBuilder(s);
            if (s.length() < longestString) {
                difference = longestString - s.length();
            }
            sb.append(" ".repeat(difference));
            modifiedList.add(sb.toString());
        }

        for (String a : modifiedList) {
            System.out.println(a + " | " + reverseLine(a));
        }
    }

    private static String reverseLine(String a) {

        StringBuilder sb = new StringBuilder(a);
        String reversedString = sb.reverse().toString();
        String finalString = "";
        for (int i = 0; i < reversedString.length(); i++) {
            if (reversedString.charAt(i) == '<') {
                finalString += '>';
            } else if (reversedString.charAt(i) == '>') {
                finalString += '<';
            } else if (reversedString.charAt(i) == '[') {
                finalString += ']';
            } else if (reversedString.charAt(i) == ']') {
                finalString += '[';
            } else if (reversedString.charAt(i) == '{') {
                finalString += '}';
            } else if (reversedString.charAt(i) == '}') {
                finalString += '{';
            } else if (reversedString.charAt(i) == '(') {
                finalString += ')';
            } else if (reversedString.charAt(i) == ')') {
                finalString += '(';
            } else if (reversedString.charAt(i) == '/') {
                finalString += '\\';
            } else if (reversedString.charAt(i) == '\\') {
                finalString += '/';
            } else {
                finalString += reversedString.charAt(i);
            }
        }

        return finalString;
    }
}
