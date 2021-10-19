package hu.gamemasters.fishing;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class Fishing extends MyGame {
	@Override
	public void create() {
		super.create();
		setScreen(new GameScreen(this));
	}
}
