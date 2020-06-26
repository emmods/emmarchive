package net.critical.flight_display.hud;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.network.ClientPlayerEntity;

import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import org.lwjgl.opengl.GL11;

import java.awt.Color;
import java.lang.Math;


@Environment(EnvType.CLIENT)
public class FlightDisplayHud implements Drawable {
    private final MinecraftClient client;
    private final TextRenderer fontRenderer;
    private ClientPlayerEntity player;
    private double last_x=0;
    private double last_y=0;
    private double last_z=0;
    private long last_time=0;
    private int speed=0;

    public FlightDisplayHud(MinecraftClient client) {
        this.client = client;
        this.fontRenderer = client.textRenderer;
    }

    public void draw() {

        int height = client.getWindow().getScaledHeight();
        int width = client.getWindow().getScaledWidth();

        double factor = 3;

        int zLevel = 1;
        double top = height/factor;
        double left = width/factor;
        double right = (width/factor) * (factor-1);
        double bottom = (height/factor) * (factor-1);
        double middle_height = height/2.0;
        double height_of_display = bottom - top;
        int number_of_hashes = 11;
        double distance_between_hashes = height_of_display / number_of_hashes;

        this.player = this.client.player;

        float pitch = this.player.getPitch(0);
        int display_pitch = (int) pitch;
        double pitch_offset = (distance_between_hashes / 10) * (display_pitch % 10);

        int lineHeight = this.fontRenderer.fontHeight + 2;
        MatrixStack matrixStack = new MatrixStack();
        this.fontRenderer.draw(matrixStack, String.format("Pitch: %s", (int) this.player.getPitch(0)*-1), (float) left+10, (float) middle_height, Color.RED.getRGB());
        this.fontRenderer.draw(matrixStack, String.format("Speed: %s", (int) this.speed ), (float) left+10, (float) bottom, Color.RED.getRGB());

        for(double hash_y = top; hash_y <= bottom + distance_between_hashes; hash_y = hash_y + distance_between_hashes) {
            double hash_y_offset = hash_y + pitch_offset;
            if (hash_y_offset >= top) {
                if (hash_y_offset <= bottom) {
                    drawLine(left - 10, hash_y + pitch_offset, left, hash_y + pitch_offset, Color.RED);
                }
            }
        }

//        this.fontRenderer.draw( String.format("%s %s %s",  (int) this.last_x, (int) this.last_y, (int) this.last_z), (float) left+10, (float) bottom+lineHeight, Color.RED.getRGB());
//        this.fontRenderer.draw( String.format("%s %s %s",  (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ()), (float) left+10, (float) bottom+(lineHeight*2), Color.RED.getRGB());
//        this.fontRenderer.draw( String.format("%s",  client.world.getTime()), (float) left+10, (float) bottom+(lineHeight*3), Color.RED.getRGB());

        drawLine(left, top, left, bottom, Color.RED);
        drawLine(right, top, right, bottom, Color.GREEN);

        if (client.world.getTime() > this.last_time+10) {
            double distance = (Math.pow(client.player.getX() -  this.last_x, 2) + Math.pow(client.player.getY() -  this.last_y, 2) + Math.pow(client.player.getZ() -  this.last_z, 2)) * 0.5;
            this.speed = (int) (distance/(client.world.getTime() - this.last_time));

            this.last_time = client.world.getTime();
            this.last_x = client.player.getX();
            this.last_y = client.player.getY();
            this.last_z = client.player.getZ();
        }

        this.client.getProfiler().pop();
    }

    private void drawLine(double x1, double y1, double x2, double y2, Color c) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_LINES, VertexFormats.POSITION_COLOR);
        buffer.vertex((double) x1, (double) y1, (double) 1).color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        buffer.vertex((double) x2, (double) y2, (double) 1).color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        tessellator.draw();
    }

    @Override
    public void render(MatrixStack matrixstack, int mouseX, int mouseY, float delta) {
    }
}