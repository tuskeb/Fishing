package hu.gamemasters.fishing;

import com.badlogic.gdx.graphics.g2d.Sprite;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GameActor extends OneSpriteStaticActor {

    public GameActor(MyGame game) {
        super(game, "badlogic.jpg");
    }

}
