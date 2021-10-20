package hu.gamemasters.fishing;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class GameScreen extends MyScreen {

    public GameScreen(MyGame game) {
        super(game);
        setBackGroundColor(0,100, 255);
        addStage(new GamStage(game), 1, true);
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }

    @Override
    protected void afterAssetsLoaded() {

    }
}
