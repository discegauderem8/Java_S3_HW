package org.example.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("1-цифры");
        System.out.println("2-буквы EN");
        System.out.println("3-буквы RU");
        Scanner scanner =new Scanner(System.in);
        System.out.println("Выберите игру");
        int num = scanner.nextInt();
        AbstractGame game = null;
        switch (num){
            case 1:game=new NumberGame(); //Спросить, почему не ругается при даункасте
                break;                    //P.S. Изменил, чтобы добавить метод ручного выхода из игры
            case 2:game=new WordGame();
                break;
            case 3:game=new WordRussianGame();
                break;
            default:
                System.out.println("такой игры еще не существует");
        }
        game.start(4,10);
        List<String> movesHistory = new ArrayList<>();
        while(game.getGameStatus().equals(GameStatus.START)){
            System.out.println("Ваш ход: введите комбинацию 4 уникальных символов (для выхода из игры введите 'stop')");
            String answer = scanner.next();
            if (answer.equals("stop")){//через == сравнивать нельзя, так как он сравнивает ссылки, а не значения!
                System.out.println("Вы вышли из игры");
                game.manualExit();
//                break; //заменил break на метод, меняющий состояние на OFF
            }else {
                movesHistory.add(answer);
                Answer answerGame = game.inputAnswer(answer);//Тоже не понял как тут работает наследование
                System.out.println(String.format("Найдено %d коров и %d быков", answerGame.getCows(), answerGame.getBulls()));
            }
        }
        System.out.println(game.getGameStatus());
        System.out.println("Игра окончена. Хотите вывести историю ходов? y - да, n (или любая другая клавиша) - нет");
        String userChoice = scanner.next();
        switch (userChoice){
            case "y": printMoves(movesHistory);
            default: break;
        }
        scanner.close();
    }

    public static void printMoves(List<String> moveList){
        int index = 1;
        for (String item: moveList) {
            System.out.println("Ход №" + index++ + ": " + item);
        }
    }
}
