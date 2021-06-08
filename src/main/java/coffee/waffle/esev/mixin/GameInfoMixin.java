package coffee.waffle.esev.mixin;

import coffee.waffle.esev.hud.FlightDisplayHud;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(value = InGameHud.class)
public abstract class GameInfoMixin {
  private FlightDisplayHud hudInfo;

  @Inject(method = "<init>(Lnet/minecraft/client/MinecraftClient;)V", at = @At(value = "RETURN"))
  private void onInit(MinecraftClient client, CallbackInfo info) {
    // Start Mixin
    System.out.println("Init Coordinates Mixin");
    this.hudInfo = new FlightDisplayHud(client);

  }

  @Inject(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/client/option/GameOptions;hudHidden:Z", ordinal = 2))
  private void onDraw(CallbackInfo info) {

    MinecraftClient minecraftClient = MinecraftClient.getInstance();

    assert minecraftClient.player != null;
    if (minecraftClient.player.isFallFlying()) {
      this.hudInfo.draw();
    }

  }

  @Inject(method = "resetDebugHudChunk", at = @At(value = "RETURN"))
  private void onReset(CallbackInfo info) {
  }
}