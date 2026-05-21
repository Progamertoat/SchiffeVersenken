package View.Rendering;

import Business.Boards.Board;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.MouseCaptureMode;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class TerminalRenderer implements Renderer {
    private Board board;
    private String title;
    private int width;
    private int height;
    private int x;
    private int y;
    private Screen terminal;

    @Override
    public void init(Board board, String title, int width, int height, int x, int y) throws IOException {
        this.board = board;
        this.title = title;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        try {
            this.terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(width, height))
                    .setMouseCaptureMode(MouseCaptureMode.CLICK)
                    .setTerminalEmulatorTitle(title)
                    .createScreen();

            terminal.startScreen();

        } catch (Exception e) {
            throw new IOException(e);
        }
    }
    double position = 0.0;
    @Override
    public void render() throws IOException {
        terminal.setCharacter((int) position % 20, 5,
                new TextCharacter('!',
                        TextColor.ANSI.RED, TextColor.ANSI.YELLOW_BRIGHT,
                        SGR.UNDERLINE, SGR.BOLD));
        terminal.refresh();
        terminal.clear();
        position += 0.09;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setSize(int width, int height) {

    }

    @Override
    public void setPosition(int x, int y) {

    }

    @Override
    public void quit() throws IOException {
        terminal.close();
    }
}
