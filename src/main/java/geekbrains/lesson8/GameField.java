package geekbrains.lesson8;

import javax.swing.*;
import java.util.Random;

public class GameField extends JPanel {

    private final Random random = new Random();
    private int tries = 0;
    private int num;
    private boolean isGameOn;
    private int number;

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void startGame(){
        this.number = random.nextInt(10)+1;
        this.isGameOn = true;
        this.tries = 2;
        MainForm.addText("Выберите число от 1 до 10"+ '\n');
        repaint();
    }

    public boolean isGameOn() {
        return isGameOn;
    }

    public void setGameOn(boolean gameOn) {
        isGameOn = gameOn;
    }

    public GameField(){
        startGame();
    }

    public boolean checkAnswer() {
        if(num != number && tries > 0){
            MainForm.addText("Вы не угадали! Осталось - " + tries + " попытки"+ '\n');
            if (num > number) {
                MainForm.addText("Загаданное число меньше"+ '\n');
            } else if (num < number) {
                MainForm.addText("Загаданное число больше"+ '\n');
            }
            return false;
        }
        else if(num != number && tries == 0){
            MainForm.addText("Вы не угадали!"+ '\n');
            return false;
        }
        else {
            MainForm.addText("Вы угадали!"+ '\n');
            return true;
        }
    }
    /*
        while(true) {
            System.out.println("Введите число от 0 до 9");
            for (tries = 2; tries >= 0;tries--){
                num = sc.nextInt();




            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            if(sc.nextInt() == 0) break;
        }
*/

}
