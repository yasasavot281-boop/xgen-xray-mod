package net.xgen.mod.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class XrayScreen extends Screen {
    private float timer = 0;

    public XrayScreen() {
        super(Text.literal("X-GEN Interface"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        timer += delta * 0.02f; // Скорость анимации
        
        // Генерация цветов (Белый <-> Фиолетовый)
        int r = (int) MathHelper.lerp((MathHelper.sin(timer) + 1) / 2, 255, 138);
        int g = (int) MathHelper.lerp((MathHelper.sin(timer) + 1) / 2, 255, 43);
        int b = (int) MathHelper.lerp((MathHelper.sin(timer) + 1) / 2, 255, 226);
        int color = (255 << 24) | (r << 16) | (g << 8) | b;

        // Отрисовка движущегося градиентного фона
        context.fillGradient(0, 0, this.width, this.height, color, 0xFF000000);
        
        context.drawCenteredTextWithShadow(this.textRenderer, "SYSTEM STATUS: ACTIVE", this.width / 2, this.height / 2, 0xFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }
}
