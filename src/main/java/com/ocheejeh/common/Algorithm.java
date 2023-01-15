package com.ocheejeh.common;

import java.util.*;

public class Algorithm {

    /**
     * takes a string and checks if the brackets
     * are balanced else returns invalid
     * e.g:
     * abc[](){} -> invalid
     * {{[]()}}}} -> invalid
     * {[(])} -> invalid
     *
     * () -> valid
     * [()] -> valid
     * {[()]} -> valid
     * ([{{[(())]}}]) -> valid
     *
     * @param s
     * @return
     */
    public static String balancedBracket(String s){
        //edge case
        if(null == s || s.isEmpty()) return "invalid";
        List test = null;
        test.subList(0, 2);
        while (s.contains("{}") || s.contains("()") || s.contains("[]")){
           s = s
                   .replaceAll("\\{}", "")
                    .replaceAll("\\[]", "")
                    .replaceAll("\\(\\)", "");
        }

        if(s.isEmpty()){
            return "valid";
        }

        return "invalid";
    }

    public static String balancedBracketWithDeque(String s){
        Deque<Character> deque = new LinkedList<>();
        if(s.length() != 0) {
            for (char ch : s.toCharArray()) {
                if (ch == '{' || ch == '(' || ch == '[') {
                    deque.addFirst(ch);
                } else if (!deque.isEmpty() && (
                    deque.peekFirst() == '{' && ch == '}' ||
                    deque.peekFirst() == '(' && ch == ')' ||
                    deque.peekFirst() == '[' && ch == ']'
                )) {
                    deque.removeFirst();
                } else return "invalid";
            }

            if (deque.isEmpty()) return "valid";
        }

        return "invalid";
    }

    public static List<String> decodeMorseCode(String signal){
        if(signal == null || signal.isEmpty())
            return null;

        List<String> translateMorseCode = List.of(
                morseCodeTable("."),
                morseCodeTable("-"),
                morseCodeTable(".."),
                morseCodeTable(".-"),
                morseCodeTable("-."),
                morseCodeTable("--"),
                morseCodeTable("..."),
                morseCodeTable("..-"),
                morseCodeTable(".-."),
                morseCodeTable(".--"),
                morseCodeTable("-.."),
                morseCodeTable("-.-"),
                morseCodeTable("--."),
                morseCodeTable("---")
        );

        if(!signal.contains("?")){
            return List.of(morseCodeTable(signal));
        } else {
            int totalSignalLength = signal.length();
            int unknownSignals = countUnknownSignals(signal);
            if(unknownSignals == 1){
                switch (totalSignalLength){
                    case 1:
                        return List.of(morseCodeTable("."), morseCodeTable("-"));
                    case 2:
                        if(signal.startsWith("?")){
                            return signal.endsWith(".") ?
                                    List.of(morseCodeTable(".."), morseCodeTable("-.")) : List.of(morseCodeTable(".-"), morseCodeTable("--"));
                        } else {
                            return signal.startsWith(".")?
                                    List.of(morseCodeTable(".."), morseCodeTable(".-")) : List.of(morseCodeTable("-."), morseCodeTable("--"));
                        }
                    case 3:
                        if(signal.charAt(0) == '?'){
                            if(signal.endsWith("..")){
                                return List.of(
                                    morseCodeTable("..."),
                                    morseCodeTable("-..")
                                );
                            } else if(signal.endsWith(".-")){
                                return List.of(
                                        morseCodeTable("..-"),
                                        morseCodeTable("-.-")
                                );
                            } else if(signal.endsWith("-.")){
                                return List.of(
                                        morseCodeTable(".-."),
                                        morseCodeTable("--.")
                                );
                            } else {
                                return List.of(
                                  morseCodeTable(".--"),
                                  morseCodeTable("---")
                                );
                            }
                        } else if(signal.charAt(1) == '?'){
                           if(signal.startsWith(".") && signal.endsWith(".")){
                               return List.of(
                                       morseCodeTable("..."),
                                       morseCodeTable(".-.")
                               );
                           } else if(signal.startsWith(".") && signal.endsWith("-")){
                               return List.of(
                                       morseCodeTable("..-"),
                                       morseCodeTable(".--")
                               );
                           } else if(signal.startsWith("-") && signal.endsWith(".")){
                               return List.of(
                                       morseCodeTable("-.."),
                                       morseCodeTable("--.")
                               );
                           } else {
                               return List.of(
                                       morseCodeTable("-.-"),
                                       morseCodeTable("---")
                               );
                           }
                        } else if(signal.charAt(2) == '?') {
                            if(signal.startsWith("..")){
                                return List.of(
                                        morseCodeTable("..."),
                                        morseCodeTable("..-")
                                );
                            } else if (signal.startsWith(".-")){
                                return List.of(
                                    morseCodeTable(".-."),
                                    morseCodeTable(".--")
                                );
                            } else if (signal.startsWith("-.")){
                                return List.of(
                                        morseCodeTable("-.."),
                                        morseCodeTable("-.-")
                                );
                            } else {
                                return List.of(
                                        morseCodeTable("--."),
                                        morseCodeTable("---")
                                );
                            }
                        }

                }
            } else if(unknownSignals == 2){
                switch (totalSignalLength){
                    case 2:
                        return List.of(
                                morseCodeTable(".."),
                                morseCodeTable(".-"),
                                morseCodeTable("-."),
                                morseCodeTable("--")
                        );
                    case 3:
                        if(signal.charAt(0) == '?' && signal.charAt(1) == '?'){
                            if(signal.endsWith(".")) {
                                return List.of(
                                        morseCodeTable("..."),
                                        morseCodeTable(".-."),
                                        morseCodeTable("-.."),
                                        morseCodeTable("--.")
                                );
                            } else {
                                return List.of(
                                        morseCodeTable("..-"),
                                        morseCodeTable(".--"),
                                        morseCodeTable("-.-"),
                                        morseCodeTable("---")
                                );
                            }
                        }  else if(signal.charAt(0) == '?' && signal.charAt(2) == '?'){
                            if(signal.charAt(1) == '.'){
                                return List.of(
                                        morseCodeTable("..."),
                                        morseCodeTable("..-"),
                                        morseCodeTable("-.."),
                                        morseCodeTable("-.-")
                                );
                            } else {
                                return List.of(
                                        morseCodeTable(".-."),
                                        morseCodeTable(".--"),
                                        morseCodeTable("--."),
                                        morseCodeTable("---")
                                );
                            }
                        } else if(signal.charAt(1) == '?' && signal.charAt(2) == '?'){
                            if(signal.startsWith(".")){
                                return List.of(
                                        morseCodeTable("..."),
                                        morseCodeTable("..-"),
                                        morseCodeTable(".-."),
                                        morseCodeTable(".--")
                                );
                            }else {
                                return List.of(
                                        morseCodeTable("-.."),
                                        morseCodeTable("-.-"),
                                        morseCodeTable("--."),
                                        morseCodeTable("---")
                                );
                            }

                        }
                }
            }

        }
        return translateMorseCode;
    }

    public static int countUnknownSignals(String signal){
        int count = 0;
        for (char ch : signal.toCharArray()) {
            if(ch == '?') count++;
        }
        return count;
    }

    public static String morseCodeTable(String s){
        Map<String, String> mapMorseCode = Map.ofEntries(
                Map.entry(".-", "A"),
                Map.entry("-..", "D"),
                Map.entry(".", "E"),
                Map.entry("--.", "G"),
                Map.entry("..", "I"),
                Map.entry("-.-", "K"),
                Map.entry("--", "M"),
                Map.entry("-.", "N"),
                Map.entry("-", "T"),
                Map.entry("---", "O"),
                Map.entry(".-.", "R"),
                Map.entry("...", "S"),
                Map.entry("..-", "U"),
                Map.entry(".--", "W")

        );
        return mapMorseCode.get(s);
    }
}


