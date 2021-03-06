package hu.gamemasters.fishing;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GamStage extends MyStage {

    public Vector2 fisherMan = new Vector2(100, 100);
    public Vector2 fishingRod = new Vector2(50, 0);
    public OneSpriteStaticActor fishingRodEndActor;
    public float degree = 45;
    public float v = 100;
    public MyLabel vLabel;

    public void generateFlying(){
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (Actor a:getActors()) {
            if (a instanceof FlyActor){
                actors.add(a);
            }
        }
        for (Actor a:actors) {
            getActors().removeValue(a, true);
        }
        Ballistics2 ballistics2 = new Ballistics2(v, MathUtils.degreesToRadians * degree, getFishingRodEnd().x, getFishingRodEnd().y);
        for(float x = getFishingRodEnd().x; x < getViewport().getWorldWidth(); x+=10) {
            addActor(new FlyActor(game, x, ballistics2.getY(x)));
        }
    }

    public Vector2 getFishingRodEnd(){
        Vector2 fishingRodEnd = new Vector2(fishingRod);
        fishingRodEnd.rotateDeg(degree);
        fishingRodEnd.add(fisherMan);
        return fishingRodEnd;
    }

    public GamStage(MyGame game) {
        super(new ResponseViewport(512), game);
        //addActor(new GameActor(game));
        addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                degree = heightToDegree(y);
                v = widthToSpeed(x);
                // System.out.println(widthToSpeed(x) + " " + degree);
                fishingRodEndActor.setPosition(getFishingRodEnd().x, getFishingRodEnd().y);
                vLabel.setText("" + (int)degree + "??");
                generateFlying();
                super.touchDragged(event, x, y, pointer);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                addActor(new FishFoodActor(game, new Ballistics2(v, MathUtils.degreesToRadians * degree, getFishingRodEnd().x, getFishingRodEnd().y), 10));
            }
        });
        addActor(vLabel = new MyLabel(game, "ASD", new Label.LabelStyle(game.getMyAssetManager().getFont("arial.ttf"), null)));
        addActor(new TesztActor(game, fisherMan.x, fisherMan.y));
        addActor(new TesztActor(game, fishingRod.x, fishingRod.y));
        addActor(fishingRodEndActor = new TesztActor(game, getFishingRodEnd().x, getFishingRodEnd().y));
    }

    public float widthToSpeed(float x) {
        float d = x / getViewport().getWorldWidth() * 100;
        return d < 0 ? 0 : d > 100 ? 100 : d;
    }

    public float heightToDegree(float y){
        float d = y / getViewport().getWorldHeight() * 90;
        return d < 0 ? 0 : d > 85 ? 85 : d;
    }

}
