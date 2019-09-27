package com.libgdx.hellolibgdx;

public class Effect
{
    float x,y,z,t;
    public Effect(Star s)
    {
        this.x=s.position.x;
        this.y=s.position.y;
        this.z=s.position.z;
        t=0.5f;
    }
}
