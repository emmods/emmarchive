/*
 Copyright Emmaffle <pridemcmod@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
*/

package coffee.waffle.prideflags;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrideFlags implements ModInitializer {
  public static final String MODID = "prideflags";
  public static final Logger LOGGER = LogManager.getLogger(MODID);

  public static final ItemGroup PRIDE_GROUP = FabricItemGroupBuilder.build(new Identifier("prideflags", "flags"), () -> new ItemStack(Register.RAINBOW_FLAG));

  @Override
  public void onInitialize() {
    Register.registerFlagItems();
    Register.registerPrideBlocks();
    Register.registerPrideBlockitems();

    LOGGER.info("Pride Flags has finished loading! \uD83C\uDFF3️\u200D\uD83C\uDF08");
  }
}
