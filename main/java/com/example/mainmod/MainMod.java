package com.example.mainmod;

import com.example.mainmod.client.ModelReloader;
import com.example.mainmod.entity.ModEntities;
import com.example.mainmod.entity.CustomEntity;
import com.example.mainmod.gui.ModScreens;
import com.example.mainmod.gui.screenhandler.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import software.bernie.geckolib.GeckoLib;

public class MainMod implements ModInitializer, ClientModInitializer {
    public static final String MODID = "mainmod";

    @Override
    public void onInitialize() {
        GeckoLib.initialize();
        ModEntities.registerEntities();
        ModScreenHandlers.register();
    }

    @Override
    public void onInitializeClient() {
        ModScreens.register();
        FabricDefaultAttributeRegistry.register(ModEntities.CUSTOM_ENTITY, CustomEntity.createAttributes());
        ModelReloader.register(); // 🔄 регистрация слушателя перезагрузки
    }
}