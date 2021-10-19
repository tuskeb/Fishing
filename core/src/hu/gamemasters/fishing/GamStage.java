package hu.gamemasters.fishing;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class GamStage extends MyStage {

    public Vector2 fisherMan = new Vector2(100, 100);
    public Vector2 fishingRod = new Vector2(50, 0);
    public OneSpriteStaticActor fishingRodEndActor;
    public float degree = 45;

    public GamStage(MyGame game) {
        super(new ResponseViewport(1024), game);
        //addActor(new GameActor(game));
        addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                degree = heightToDegree(y);
                System.out.println(widthToN(x) + " " + degree);
                Vector2 fishingRodEnd = new Vector2(fishingRod);
                fishingRodEnd.rotateDeg(heightToDegree(y));
                fishingRodEnd.add(fisherMan);
                fishingRodEndActor.setPosition(fishingRodEnd.x, fishingRodEnd.y);
                super.touchDragged(event, x, y, pointer);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        Vector2 fishingRodEnd = new Vector2(fishingRod);
        fishingRodEnd.rotateDeg(degree);
        fishingRodEnd.add(fisherMan);
        addActor(new TesztActor(game, fisherMan.x, fisherMan.y));
        addActor(new TesztActor(game, fishingRod.x, fishingRod.y));
        addActor(fishingRodEndActor = new TesztActor(game, fishingRodEnd.x, fishingRodEnd.y));
    }

    public float widthToN(float x) {
        float d = x / getViewport().getWorldWidth() * 60;
        return d < 0 ? 0 : d > 60 ? 60 : d;
    }

    public float heightToDegree(float y){
        float d = y / getViewport().getWorldHeight() * 90;
        return d < 0 ? 0 : d > 90 ? 90 : d;
    }

}
