/*
 Copyright Emmaffle <pridemcmod@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
*/

package coffee.waffle.prideflags;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PrideFlagsRegistry {
  public static final String MODID = "prideflags";

  public static Item RAINBOW_FLAG, TRANS_FLAG, NONBINARY_FLAG, GENDERFLUID_FLAG, BI_FLAG, LESBIAN_FLAG, ACE_FLAG, ARO_FLAG, PAN_FLAG, POLY_FLAG, AGENDER_FLAG, MLM_FLAG, RAINBOW_COOKIE, TRANS_COOKIE, NONBINARY_COOKIE, GENDERFLUID_COOKIE, BI_COOKIE, LESBIAN_COOKIE, ACE_COOKIE, ARO_COOKIE, PAN_COOKIE, POLY_COOKIE, AGENDER_COOKIE, MLM_COOKIE;
  public static Block RAINBOW_BLOCK, TRANS_BLOCK, NONBINARY_BLOCK, GENDERFLUID_BLOCK, BI_BLOCK, LESBIAN_BLOCK, ACE_BLOCK, ARO_BLOCK, PAN_BLOCK, POLY_BLOCK, AGENDER_BLOCK, MLM_BLOCK;

  public static final ItemGroup PRIDE_GROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "pride_group")).icon(() -> new ItemStack(RAINBOW_FLAG)).build();

  public static void register() {
    RAINBOW_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "rainbow_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    TRANS_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "trans_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    NONBINARY_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "nonbinary_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    GENDERFLUID_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "genderfluid_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    BI_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "bi_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    LESBIAN_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "lesbian_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    ACE_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "ace_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    ARO_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "aro_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    PAN_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "pan_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    POLY_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "poly_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    AGENDER_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "agender_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));
    MLM_FLAG = Registry.register(Registry.ITEM, new Identifier(MODID, "mlm_flag"), new Item(new FabricItemSettings().group(PRIDE_GROUP)));

    RAINBOW_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "rainbow_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    TRANS_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "trans_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    NONBINARY_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "nonbinary_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    GENDERFLUID_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "genderfluid_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    BI_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "bi_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    LESBIAN_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "lesbian_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    ACE_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "ace_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    ARO_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "aro_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    PAN_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "pan_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    POLY_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "poly_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    AGENDER_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "agender_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));
    MLM_COOKIE = Registry.register(Registry.ITEM, new Identifier(MODID, "mlm_cookie"), new Item(new FabricItemSettings().group(PRIDE_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5F).build())));

    Registry.register(Registry.BLOCK, new Identifier(MODID, "rainbow_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "trans_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "nonbinary_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "genderfluid_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "bi_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "lesbian_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "ace_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "aro_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "pan_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "poly_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "agender_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));
    Registry.register(Registry.BLOCK, new Identifier(MODID, "mlm_block"), new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL)));

    Registry.register(Registry.ITEM, new Identifier(MODID, "rainbow_block"), new BlockItem(RAINBOW_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "trans_block"), new BlockItem(TRANS_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "nonbinary_block"), new BlockItem(NONBINARY_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "genderfluid_block"), new BlockItem(GENDERFLUID_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "bi_block"), new BlockItem(BI_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "lesbian_block"), new BlockItem(LESBIAN_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "ace_block"), new BlockItem(ACE_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "aro_block"), new BlockItem(ARO_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "pan_block"), new BlockItem(PAN_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "poly_block"), new BlockItem(POLY_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "agender_block"), new BlockItem(AGENDER_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "mlm_block"), new BlockItem(MLM_BLOCK, new FabricItemSettings().group(PRIDE_GROUP)));
  }
}
