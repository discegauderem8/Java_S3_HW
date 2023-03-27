package org.example.game;

import java.util.ArrayList;
import java.util.List;

public class WordRussianGame extends AbstractGame{
    @Override
    List<String> generateCharList() {
        List<String> charList = new ArrayList<String>();
        String engAplhabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for (int i = 0; i < engAplhabet.length(); ++i) {
            charList.add(Character.toString(engAplhabet.charAt(i)));
        }
        return charList;
    }
}