package coffee.waffle.esev.hud;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

@Environment(EnvType.CLIENT)
public class FlightDisplayHud implements Drawable {
  private final MinecraftClient client;
  private final TextRenderer fontRenderer;
  private double last_x = 0;
  private double last_y = 0;
  private double last_z = 0;
  private long last_time = 0;
  private int speed = 0;

  public FlightDisplayHud(MinecraftClient client) {
    this.client = client;
    this.fontRenderer = client.textRenderer;
  }

  public void draw() {
    int height = client.getWindow().getScaledHeight();
    int width = client.getWindow().getScaledWidth();

    double factor = 3;

    double left = width / factor;
    double right = (width / factor) * (factor - 1);
    double middle_height = height / 2.0;

    ClientPlayerEntity player = this.client.player;

    assert player != null;
    MatrixStack matrixStack = new MatrixStack();
    this.fontRenderer.draw(matrixStack, String.format("Pitch: %s", (int) player.getPitch(0)), (float) left, (float) middle_height, Color.RED.getRGB());
    this.fontRenderer.draw(matrixStack, String.format("Speed: %s", this.speed), (float) right, (float) middle_height, Color.RED.getRGB());

    assert client.world != null;
    if (client.world.getTime() > this.last_time + 10) {
      double distance = (Math.pow(client.player.getX() - this.last_x, 2) + Math.pow(client.player.getY() - this.last_y, 2) + Math.pow(client.player.getZ() - this.last_z, 2)) * 0.5;
      this.speed = (int) (distance / (client.world.getTime() - this.last_time));

      this.last_time = client.world.getTime();
      this.last_x = client.player.getX();
      this.last_y = client.player.getY();
      this.last_z = client.player.getZ();
    }

    this.client.getProfiler().pop();
  }

  @Override
  public void render(MatrixStack matrixstack, int mouseX, int mouseY, float delta) {
  }
}