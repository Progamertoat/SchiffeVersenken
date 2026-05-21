package View.Rendering;

import Business.Boards.Board;

import javax.swing.*;
import java.awt.*;

public class SwingRenderer extends JFrame implements Renderer {

    private Board board;
    private BoardPanel panel;

    @Override
    public void init(Board board, String title, int width, int height, int x, int y) {
        this.board = board;

        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x, y);
        setResizable(false);

        panel = new BoardPanel(board);
        add(panel);

        setVisible(true);
    }

    @Override
    public void render() {
        if (panel != null) {
            panel.repaint(); // triggers paintComponent
        }
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        if (panel != null) panel.repaint();
    }

    @Override
    public void setPosition(int x, int y) {
        setLocation(x, y);
    }

    @Override
    public void quit() {
        dispose();
    }
}