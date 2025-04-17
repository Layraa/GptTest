package com.example.mainmod.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;

public class EntityEditorScreen extends Screen {
    private TextFieldWidget nameField, healthField, speedField;

    public EntityEditorScreen() {
        super(Text.literal("Entity Editor"));
    }

    @Override
    protected void init() {
        this.nameField = new TextFieldWidget(textRenderer, width / 2 - 100, 40, 200, 20, Text.literal("Name"));
        this.healthField = new TextFieldWidget(textRenderer, width / 2 - 100, 70, 200, 20, Text.literal("Health"));
        this.speedField = new TextFieldWidget(textRenderer, width / 2 - 100, 100, 200, 20, Text.literal("Speed"));

        addSelectableChild(nameField);
        addSelectableChild(healthField);
        addSelectableChild(speedField);

        addDrawableChild(ButtonWidget.builder(Text.literal("Save Preset"), button -> savePreset()).dimensions(width / 2 - 100, 130, 200, 20).build());
        addDrawableChild(ButtonWidget.builder(Text.literal("Reload Models"), button -> {
            MinecraftClient.getInstance().reloadResources(); // 🔥 горячая перезагрузка
        }).dimensions(width / 2 - 100, 160, 200, 20).build());
    }

    private void savePreset() {
        Preset preset = new Preset(nameField.getText(), getFloat(healthField.getText()), getFloat(speedField.getText()));
        PresetManager.savePreset(preset, preset.name);
    }

    private float getFloat(String text) {
        try {
            return Float.parseFloat(text);
        } catch (NumberFormatException e) {
            return 0.0f;
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, textRenderer, "Custom Entity Editor", width / 2, 15, 0xFFFFFF);
        nameField.render(matrices, mouseX, mouseY, delta);
        healthField.render(matrices, mouseX, mouseY, delta);
        speedField.render(matrices, mouseX, mouseY, delta);
        super.render(matrices, mouseX, mouseY, delta);
    }
}