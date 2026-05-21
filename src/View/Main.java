package View;

import Business.Boards.Board;
import Business.Boards.FriendlyBoard;
import View.Rendering.SwingRenderer;
import View.Rendering.TerminalRenderer;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main() throws IOException, InterruptedException {
        new SwingRenderer().init(new FriendlyBoard(10), "Yo", 1000, 1000, 0, 0);

    }
}
