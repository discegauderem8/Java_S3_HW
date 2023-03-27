package org.example.game;

import java.util.ArrayList;
import java.util.List;

public class NumberGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> charList = new ArrayList<String>();
        for (int i = 0; i < 10; ++i) {
            charList.add(String.valueOf(i));
        }
        return charList;
    }
}
