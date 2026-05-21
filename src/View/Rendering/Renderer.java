package View.Rendering;

import Business.Boards.Board;
import Business.Ships.Ship;

import java.io.IOException;

public interface Renderer {
    void init(Board board, String title, int width, int height, int x, int y) throws IOException;
    void render() throws IOException;
    void setTitle(String title);
    void setSize(int width, int height);
    void setPosition(int x, int y);
    void quit() throws IOException;
}
