package com.example.mainmod.gui;

import com.example.mainmod.entity.ModEntities;
import com.example.mainmod.entity.CustomEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ModScreens {
    public static void register() {
        EntityRendererRegistry.register(ModEntities.CUSTOM_ENTITY, CustomEntityRenderer::new);
    }
}
