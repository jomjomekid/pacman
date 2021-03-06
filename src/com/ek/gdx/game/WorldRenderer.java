package com.ek.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer extends ScreenAdapter {
	
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
	private Pacman pacman;
	private SpriteBatch batch;
	private MazeRenderer mazeRenderer;
	public static final int BLOCK_SIZE = 40;
	private BitmapFont font;
	World world;
	
	public WorldRenderer(PacmanGame pacmanGame, World world) {
        this.pacmanGame = pacmanGame;
        batch  = this.pacmanGame.batch;
        this.world = world;
        pacmanImg = new Texture("pacman.png");
        pacman  = world.getPacman();
        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
        font = new BitmapFont();
    }
	
	@Override
	 public void render(float delta) {
	    	Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        //Vector2 pos = pacman.getPosition();
	        mazeRenderer.render();
	        SpriteBatch batch = pacmanGame.batch;
	        Vector2 pos = world.getPacman().getPosition();
	        batch.begin();
	        batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
	        font.draw(batch, "" + world.getScore(), 700, 60);
	        batch.end();
	    }

}
