package club.cheapok.java.basics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListenerDemo extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        System.out.printf("x:=%d and y:=%d",x,y);
    }

    public static void main(String[] args) {

    }
}
