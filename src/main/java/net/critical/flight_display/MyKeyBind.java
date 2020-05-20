package net.critical.flight_display;

import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;

import net.fabricmc.fabric.mixin.client.keybinding.KeyCodeAccessor;

public class MyKeyBind {
    private static String categoryName = "Flight Display";
    private static FabricKeyBinding keyBinding = FabricKeyBinding.Builder.create(
            new Identifier("toggle", "flight_display"),
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_K,
            categoryName
    ).build();;
    private boolean pressedLastTick = false;

    public MyKeyBind() {

        KeyBindingRegistry.INSTANCE.addCategory(categoryName);
        KeyBindingRegistry.INSTANCE.register(keyBinding);


        ClientTickCallback.EVENT.register(e ->
        {
            if (keyBinding.isPressed() != pressedLastTick)
            {
                pressedLastTick = keyBinding.isPressed();
                if (pressedLastTick)
                {
                    onPress();
                }
                else
                {
                    onRelease();
                }
            }
        });


    }

    private void onPress()
    {
        FlightDisplay.toggle();
    }

    private void onRelease()
    {

    }


}
