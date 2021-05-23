/*
 * Copyright Emmaffle <chocobacon@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 * (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
 */

package coffee.waffle.chocobacon;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static coffee.waffle.chocobacon.ChocobaconRegistry.STILL_CHOCOLATE;

public class Chocobacon implements ModInitializer {
  public static final String MODID = "chocobacon";
  public static final Logger LOGGER = LogManager.getLogger(MODID);

  public static final ItemGroup CHOCOBACON_GROUP = FabricItemGroupBuilder.create(new Identifier("chocobacon", "chocobacon_group")).icon(() -> new ItemStack(ChocobaconRegistry.CHOCOLATE_BACON)).build();

  public static Block CHOCOLATE_FLUID;

  @Override
  public void onInitialize() {
    ChocobaconRegistry.register();
    CHOCOLATE_FLUID = Registry.register(Registry.BLOCK, new Identifier(MODID, "chocolate"), new FluidBlock(STILL_CHOCOLATE, FabricBlockSettings.copy(Blocks.WATER)) {
    });

    // Send confirmation to console
    LOGGER.info("Chocobacon has finished loading - enjoy yer bacon & chocolate :)");
  }
}
