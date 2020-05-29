package net.critical.flight_display.mixin;

import net.critical.flight_display.FlightDisplay;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.critical.flight_display.hud.FlightDisplayHud;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(value = InGameHud.class)
public abstract class GameInfoMixin {
    private FlightDisplayHud hudInfo;

    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method = "<init>(Lnet/minecraft/client/MinecraftClient;)V", at = @At(value = "RETURN"))
    private void onInit(MinecraftClient client, CallbackInfo ci) {
        // Start Mixin
        System.out.println("Init Coordinates Mixin");
        this.hudInfo = new FlightDisplayHud(client);
        //keyBinding = MyKeyBind.keyBinding;

    }

    @Inject(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/client/options/GameOptions;hudHidden:Z", ordinal = 2))
    private void onDraw(float esp, CallbackInfo ci) {

        MinecraftClient minecraftClient = MinecraftClient.getInstance();

        if (minecraftClient.player != null) {
            if (minecraftClient.player.isFallFlying()) {
                this.hudInfo.draw();
            }
        }
    }

    @Inject(method = "resetDebugHudChunk", at = @At(value = "RETURN"))
    private void onReset(CallbackInfo ci) {
    }
}