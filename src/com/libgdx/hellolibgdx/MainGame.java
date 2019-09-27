package com.libgdx.hellolibgdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MainGame implements ApplicationListener
{
    public void create()
    {
    }

    public void resize(int width, int height)
    {
    }

    public void resume()
    {
    }

    public void pause()
    {
    }

    public void render()
    {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    public void dispose()
    {
    }
}
