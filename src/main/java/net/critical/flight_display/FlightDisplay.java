package net.critical.flight_display;

import net.fabricmc.api.ModInitializer;
import net.minecraft.text.LiteralText;
import net.minecraft.client.MinecraftClient;

public class FlightDisplay implements ModInitializer {

    private static boolean enabled = false;

    public static boolean isEnabled()
    {
        return FlightDisplay.enabled;
    }

    public static void toggle()
    {
        FlightDisplay.enabled = !FlightDisplay.enabled;
        MinecraftClient client = MinecraftClient.getInstance();
        if (FlightDisplay.isEnabled())
        {
            client.player.addChatMessage(new LiteralText("Flight Display Enabled"), false);
        }
        else
        {
            client.player.addChatMessage(new LiteralText("Flight Display Disabled"), false);

        }
    }

    @Override
    public void onInitialize() {
        /*
          This code runs as soon as Minecraft is in a mod-load-ready state.
          However, some things (like resources) may still be unitialized.
          Proceed with mild caution.
         */
        new MyKeyBind();
        System.out.println("Flight Display Mod started.");

    }
}
