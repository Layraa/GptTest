package com.example.mainmod.entity;

import com.example.mainmod.entity.CustomEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import com.example.mainmod.MainMod;

public class CustomEntityModel extends GeoModel<CustomEntity> {

    @Override
    public Identifier getModelResource(CustomEntity animatable) {
        return new Identifier(MainMod.MODID, "geo/custom_entity.geo.json");
    }

    @Override
    public Identifier getTextureResource(CustomEntity animatable) {
        return new Identifier(MainMod.MODID, "textures/entity/custom_entity.png");
    }

    @Override
    public Identifier getAnimationResource(CustomEntity animatable) {
        return new Identifier(MainMod.MODID, "animations/custom_entity.animation.json");
    }
}
