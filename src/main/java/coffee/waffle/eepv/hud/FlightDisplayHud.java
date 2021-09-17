/*
 * Copyright (c) 2020 Bert Shuler
 * Copyright (c) 2021 wafflecoffee
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package coffee.waffle.eepv.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.hud.DebugHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;

public class FlightDisplayHud implements Drawable {
  private final MinecraftClient client;
  private final TextRenderer fontRenderer;

  public FlightDisplayHud(@NotNull MinecraftClient client) {
    this.client = client;
    this.fontRenderer = client.textRenderer;
  }

  public void draw() {
    ClientPlayerEntity player = this.client.player;

    assert player != null;
    this.fontRenderer.drawWithShadow(new MatrixStack(),
            String.format("Pitch: %s", player.getPitch(0)),
            4, 4, 16733525);


    this.client.getProfiler().pop();
  }

  @Override
  public void render(MatrixStack matrixstack, int mouseX, int mouseY, float delta) {
  }
}