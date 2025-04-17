package com.example.mainmod.entity;

import com.example.mainmod.entity.CustomEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import com.example.mainmod.MainMod;

public class CustomEntityRenderer extends GeoEntityRenderer<CustomEntity> {
    public CustomEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CustomEntityModel());
    }

    @Override
    public Identifier getTextureLocation(CustomEntity entity) {
        return new Identifier(MainMod.MODID, "textures/entity/custom_entity.png");
    }
}
