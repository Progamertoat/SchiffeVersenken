package View.Rendering;

import Business.Boards.Board;
import Business.Ships.ShipPart;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

class BoardPanel extends JPanel {
    private final Board board;
    Image wellen;
    public BoardPanel(Board board) {
        this.board = board;
        wellen = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Wellen.png"))).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = board.getSize();
        ShipPart[][] field = board.getField();

        int cellSize = Math.min(getWidth(), getHeight()) / size;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {

                ShipPart part = field[y][x];

                g.setColor(Color.BLUE);
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                g.drawImage(wellen, x * cellSize, y * cellSize, cellSize, cellSize, null);

                if (part == null) {
                    g.setColor(Color.darkGray);
                }
                else {
                    if (part.isHit()) {
                        g.setColor(Color.RED);
                    }
                    else  {
                        g.setColor(Color.GREEN);
                    }
                }

                // grid lines
                g.setColor(Color.BLACK);
                g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);

            }
        }
    }
}
