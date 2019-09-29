package com.libgdx.hellolibgdx;

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.*;

import java.util.*;

public class Star
{
    Color color;
    float mess, size;
    Vector3 position, velocity;
    ArrayList<Effect> effects;

    public Star(float m, float px, float py, float pz,
                float vx, float vy, float vz)
    {
        mess = m;
        size = 6 * (float) Math.sqrt((double) m);
        position = new Vector3(px, py, pz);
        velocity = new Vector3(vx, vy, vz);
        color = new Color(Color.RED);
        effects = new ArrayList<Effect>();
    }

    public void setColor(float r, float g, float b)
    {
        color.set(r, g, b, 1);
    }

    public void addVel(Vector3 addv, float dt)
    {
        velocity.add(addv.scl(dt));
    }

    public Vector3 getPos()
    {
        return new Vector3(position);
    }

    public Vector3 getVel()
    {
        return new Vector3(velocity);
    }

    public Color getColor()
    {
        return new Color(color);
    }
}
