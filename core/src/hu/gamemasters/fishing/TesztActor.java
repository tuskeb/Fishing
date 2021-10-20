package hu.gamemasters.fishing;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class TesztActor extends OneSpriteStaticActor {
    public TesztActor(MyGame game, float x, float y) {
        super(game, "fishercutbody.png");
        setWidth(38);
        setHeight(102);
        setPosition(x,y);
    }
}
