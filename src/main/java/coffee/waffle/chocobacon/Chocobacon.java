/*
 * Copyright Emmaffle <chocobacon@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 * (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
 */

package coffee.waffle.chocobacon;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chocobacon implements ModInitializer {
  public static final String MOD_ID = "chocobacon";
  public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

  public static final ItemGroup CHOCOBACON_GROUP = FabricItemGroupBuilder.create(new Identifier("chocobacon", "chocobacon_group")).icon(() -> new ItemStack(RegisterItems.CHOCOLATE_BACON)).build();


  @Override
  public void onInitialize() {
    RegisterItems.register();

    // Send confirmation to console
    LOGGER.info("Chocobacon has finished loading - enjoy yer bacon & chocolate :)");
  }
}
