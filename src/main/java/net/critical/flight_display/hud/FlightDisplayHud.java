package net.critical.flight_display.hud;

import com.google.common.collect.Lists;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.critical.flight_display.mixin.GameClientMixin;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
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
        this.fontRenderer.draw( String.format("Pitch: %s", (int) this.player.getPitch(0)), (float) left+10, (float) middle_height, Color.RED.getRGB());
        this.fontRenderer.draw( String.format("Speed: %s", (int) this.speed ), (float) left+10, (float) bottom, Color.RED.getRGB());

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

    private void drawInfos() {
        // Draw lines of Array of Game info in the screen

        List<String> gameInfo = getGameInfo();
        drawEquipementInfo();

        int lineHeight = this.fontRenderer.fontHeight + 2;
        int top = 0;
        int left = 4;

        for (String line : gameInfo) {
            this.fontRenderer.draw(line, left, top + 4, Color.lightGray.getRGB());
            top += lineHeight;
        }

        if (this.player.isSprinting()) {
            final String sprintingText = "Sprinting";

            int maxLineHeight = Math.max(10, this.fontRenderer.getStringWidth(sprintingText));
            maxLineHeight = (int) (Math.ceil(maxLineHeight / 5.0D + 0.5D) * 5);
            int scaleHeight = this.client.getWindow().getScaledHeight();
            int sprintingTop = scaleHeight - maxLineHeight;

            // Sprinting Info
            this.fontRenderer.draw(sprintingText, 2, sprintingTop + 20, Color.lightGray.getRGB());
        }
    }

    private static String capitalize(String str) {
        // Capitalize first letter of a String
        if (str == null) return null;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String getOffset(Direction facing) {
        String offset = "";

        if (facing.getOffsetX() > 0) {
            offset += "+X";
        } else if (facing.getOffsetX() < 0) {
            offset += "-X";
        }

        if (facing.getOffsetZ() > 0) {
            offset += " +Z";
        } else if (facing.getOffsetZ() < 0) {
            offset += " -Z";
        }

        return offset.trim();
    }

    private String zeroPadding(int number) {
        return (number >= 10) ? Integer.toString(number) : String.format("0%s", number);
    }

    private String secondsToString(int pTime) {
        final int min = pTime / 60;
        final int sec = pTime - (min * 60);

        final String strMin = zeroPadding(min);
        final String strSec = zeroPadding(sec);
        return String.format("%s:%s", strMin, strSec);
    }

    private void drawStatusEffectInfo() {
        if (this.client.player != null) {
            Map<StatusEffect, StatusEffectInstance> effects = this.client.player.getActiveStatusEffects();

            for (Map.Entry<StatusEffect, StatusEffectInstance> effect : effects.entrySet()) {
                String effectName = I18n.translate(effect.getKey().getTranslationKey());

                String duration = secondsToString(effect.getValue().getDuration() / 20);

                int color = effect.getKey().getColor();

                this.fontRenderer.draw(effectName + " " + duration, 40, 200, color);
            }
        }
    }

    private void drawEquipementInfo() {
        List<ItemStack> equippedItems = new ArrayList<>();
        PlayerInventory inventory = this.player.inventory;
        int maxLineHeight = Math.max(10, this.fontRenderer.getStringWidth(""));

        ItemStack mainHandItem = inventory.getMainHandStack();
        maxLineHeight = Math.max(maxLineHeight, this.fontRenderer.getStringWidth(I18n.translate(mainHandItem.getTranslationKey())));
        equippedItems.add(mainHandItem);

        for (ItemStack secondHandItem : inventory.offHand) {
            maxLineHeight = Math.max(maxLineHeight, this.fontRenderer.getStringWidth(I18n.translate(secondHandItem.getTranslationKey())));
            equippedItems.add(secondHandItem);
        }

        for (ItemStack armourItem : this.player.inventory.armor) {
            maxLineHeight = Math.max(maxLineHeight, this.fontRenderer.getStringWidth(I18n.translate(armourItem.getTranslationKey())));
            equippedItems.add(armourItem);
        }

        maxLineHeight = (int) (Math.ceil(maxLineHeight / 5.0D + 0.5D) * 5);
        int itemTop = this.client.getWindow().getScaledHeight() - maxLineHeight;

        int lineHeight = this.fontRenderer.fontHeight + 6;

        // Draw in order Helmet -> Chestplate -> Leggings -> Boots
        for (ItemStack equippedItem : Lists.reverse(equippedItems)) {
            if (equippedItem.getItem().equals(Blocks.AIR.asItem())) {
                // Skip empty slots
                continue;
            }

            this.client.getItemRenderer().renderGuiItemIcon(equippedItem, 2, itemTop - 68);

            if (equippedItem.getMaxDamage() != 0) {
                int currentDurability = equippedItem.getMaxDamage() - equippedItem.getDamage();

                String itemDurability = currentDurability + "/" + equippedItem.getMaxDamage();

                // Default Durability Color
                int color = Color.lightGray.getRGB();

                if (currentDurability < equippedItem.getMaxDamage()) {
                    // Start as Green if item has lost at least 1 durability
                    color = Color.green.getRGB();
                }
                if (currentDurability <= (equippedItem.getMaxDamage() / 1.5)) {
                    color = Color.yellow.getRGB();
                }
                if (currentDurability <= (equippedItem.getMaxDamage() / 2.5)) {
                    color = Color.orange.getRGB();
                }
                if (currentDurability <= (equippedItem.getMaxDamage()) / 4) {
                    color = Color.red.getRGB();
                }

                this.fontRenderer.draw(itemDurability, 22, itemTop - 64, color);
            } else {
                int count = equippedItem.getCount();

                if (count > 1) {
                    String itemCount = String.valueOf(count);
                    this.fontRenderer.draw(itemCount, 22, itemTop - 64, Color.lightGray.getRGB());
                }
            }

            itemTop += lineHeight;
        }
    }

    private static String parseTime(long time) {
        long hours = (time / 1000 + 6) % 24;
        long minutes = (time % 1000) * 60 / 1000;
        String ampm = "AM";

        if (hours >= 12) {
            hours -= 12;
            ampm = "PM";
        }

        if (hours >= 12) {
            hours -= 12;
            ampm = "AM";
        }

        if (hours == 0) hours = 12;

        String mm = "0" + minutes;
        mm = mm.substring(mm.length() - 2);

        return hours + ":" + mm + " " + ampm;
    }

    private List<String> getGameInfo() {
        List<String> gameInfo = new ArrayList<>();

        Direction facing = this.player.getHorizontalFacing();

        String coordsFormat = "%.0f, %.0f, %.0f %s";
        String pitchyawFormat = "pitch: %.0f yaw: %.0f";

        String direction = "(" + capitalize(facing.asString()) + " " + getOffset(facing) + ")";

        // Coordinates and Direction info
        gameInfo.add(String.format(coordsFormat, this.player.getX(), this.player.getY(), this.player.getZ(), direction));

        // Pitch and Yaw info
        gameInfo.add(String.format(pitchyawFormat, this.player.getPitch(0), this.player.getYaw(0)));

        // Get everything from fps debug string until the 's' from 'fps'
        // gameInfo.add(client.fpsDebugString.substring(0, client.fpsDebugString.indexOf("s") + 1));
        gameInfo.add(String.format("%d fps", ((GameClientMixin) client.getInstance()).getCurrentFps()));

        // Get translated biome info
        if (client.world != null) {
            gameInfo.add(I18n.translate(client.world.getBiome(this.player.getBlockPos()).getTranslationKey()) + " Biome");

            // Add current parsed time
            gameInfo.add(parseTime(client.world.getTimeOfDay()));
        }

        return gameInfo;
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
    }
}