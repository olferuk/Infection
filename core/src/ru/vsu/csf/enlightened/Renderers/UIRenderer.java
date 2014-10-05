package ru.vsu.csf.enlightened.Renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.vsu.csf.enlightened.GameObjects.Game;
import ru.vsu.csf.enlightened.GameObjects.Player;

import java.util.ArrayList;

/** Created by enlightenedcsf on 02.10.14. */
public class UIRenderer {

    private static final int MARGIN_TOP  = 40;
    private static final int MARGIN_LEFT = 10;
    private static final int PLAYER_ICON_SIZE = 30;

    BitmapFont font;
    Texture pieceRed, pieceBlue, pieceGreen, piecePurple, pieceYellow;
    Texture selectionMark;
    Texture defeatMark;
    Batch batch;

    public UIRenderer() {
        batch = new SpriteBatch();
        font = new BitmapFont() {{
            setColor(Color.GRAY);
        }};
        pieceRed = new Texture("pieceRed.png");
        pieceBlue = new Texture("pieceBlue.png");
        pieceGreen = new Texture("pieceGreen.png");
        piecePurple = new Texture("piecePurple.png");
        pieceYellow = new Texture("pieceYellow.png");
        selectionMark = new Texture("selectionMark.png");
        defeatMark = new Texture("defeatMark.png");
    }

    public void render() {
        ArrayList<Player> players = Game.getGame().getPlayers();

        batch.begin();
        int i = -1;
        for (Player player : players) {
            i++;

            if (Game.getGame().getCurrentPlayer() == player) {
                batch.draw(selectionMark, MARGIN_LEFT, 480 - MARGIN_TOP - i*(PLAYER_ICON_SIZE + 5), PLAYER_ICON_SIZE, PLAYER_ICON_SIZE);
            }

            switch (player.getColor()) {
                case RED:
                    batch.draw(pieceRed, MARGIN_LEFT, 480 - MARGIN_TOP - i*(PLAYER_ICON_SIZE + 5), PLAYER_ICON_SIZE, PLAYER_ICON_SIZE);
                    break;
                case GREEN:
                    batch.draw(pieceGreen, MARGIN_LEFT, 480 - MARGIN_TOP - i*(PLAYER_ICON_SIZE + 5), PLAYER_ICON_SIZE, PLAYER_ICON_SIZE);
                    break;
                case PURPLE:
                    batch.draw(piecePurple, MARGIN_LEFT, 480 - MARGIN_TOP - i*(PLAYER_ICON_SIZE + 5), PLAYER_ICON_SIZE, PLAYER_ICON_SIZE);
                    break;
                case YELLOW:
                    batch.draw(pieceYellow, MARGIN_LEFT, 480 - MARGIN_TOP - i*(PLAYER_ICON_SIZE + 5), PLAYER_ICON_SIZE, PLAYER_ICON_SIZE);
                    break;
                case BLUE:
                    batch.draw(pieceBlue, MARGIN_LEFT, 480 - MARGIN_TOP - i*(PLAYER_ICON_SIZE + 5), PLAYER_ICON_SIZE, PLAYER_ICON_SIZE);
                    break;
            }

            if (player.wasDefeated()) {
                batch.draw(defeatMark, MARGIN_LEFT, 480 - MARGIN_TOP - i*(PLAYER_ICON_SIZE + 5), PLAYER_ICON_SIZE, PLAYER_ICON_SIZE);
            }

            font.draw(batch, player.getScore()+"", MARGIN_LEFT + PLAYER_ICON_SIZE + 5, 480 - MARGIN_TOP - i*(PLAYER_ICON_SIZE) + 20);
        }
        batch.end();
    }
}
