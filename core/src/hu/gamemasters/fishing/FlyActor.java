package hu.gamemasters.fishing;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FlyActor extends OneSpriteStaticActor {

    public FlyActor(MyGame game, float x, float y) {
        super(game, "fisher.png");
        setWidth(10);
        setHeight(10);
        setPosition(x,y);
    }

}
