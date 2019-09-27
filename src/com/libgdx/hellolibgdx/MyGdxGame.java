package com.libgdx.hellolibgdx;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.math.*;

import java.util.*;

public class MyGdxGame implements ApplicationListener
{
    private SpriteBatch batch;
    private ShapeRenderer render;
    private BitmapFont font;

    private ArrayList<Star> stars;
    private float G = 50000000;

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        render = new ShapeRenderer();
        font = new BitmapFont();
        stars = new ArrayList<Star>();
        stars.add(new Star(11, 500, 1200, 0, 620, 0, 0));
        stars.add(new Star(13, 500, 700, 0, -620, 0, 0));
        stars.add(new Star(1, 600, 200, 0, 1240, 0, 0));
        stars.get(1).setColor(1, 0.5f, 0);
        stars.get(2).setColor(0, 7f, 0.8f);
    }

    @Override
    public void resize(int i, int i1)
    {

    }

    @Override
    public void render()
    {
        float dt = Gdx.graphics.getDeltaTime();
        for (Star i : stars)
        {
            for (Star j : stars)
            {
                if (i.equals(j)) continue;
                Vector3 fx = j.getPos().sub(i.position);//direction
                float dx = G * j.mess / i.position.dst2(i.position);//value
                i.addVel(fx.scl(dx / fx.len()), dt);

            }
        }

        for (Star i : stars)
        {
            i.position.add(i.getVel().scl(dt));
            i.effects.add(new Effect(i));
        }

        batch.begin();
        font.draw(batch, stars.get(2).velocity.toString(), 100, 100);
        batch.end();

        //绘制星球
        render.begin(ShapeRenderer.ShapeType.Filled);
        for (Star s : stars)
        {
            render.setColor(s.color);
            render.circle(s.position.x, s.position.y, s.size);
            Effect ea, eb = s.effects.get(0);
            while (eb.t < 0)
            {
                s.effects.remove(0);
                eb = s.effects.get(0);
            }
            for (int i = 1; i < s.effects.size(); ++i)
            {
                ea = eb;
                eb = s.effects.get(i);
                render.line(ea.x, ea.y, eb.x, eb.y);
                ea.t -= dt;
            }
        }
        render.end();
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void dispose()
    {

    }
}
