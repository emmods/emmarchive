package net.critical.flight_display;

import net.fabricmc.api.ModInitializer;

public class FlightDisplay implements ModInitializer {

    @Override
    public void onInitialize() {
        /*
          This code runs as soon as Minecraft is in a mod-load-ready state.
          However, some things (like resources) may still be unitialized.
          Proceed with mild caution.
         */
        System.out.println("Flight Display Mod started.");

    }
}
