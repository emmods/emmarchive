/*
 Copyright Emmaffle <pridemcmod@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
*/

package coffee.waffle.prideflags;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Register {
  // Declaring flag items
  public static final Item RAINBOW_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item TRANS_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item NONBINARY_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item GENDERFLUID_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item BI_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item LESBIAN_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item ACE_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item ARO_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item PAN_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item POLY_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item AGENDER_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));
  public static final Item MLM_FLAG = new Item(new FabricItemSettings().group(PrideFlags.PRIDE_GROUP));

  // Declaring flag blocks
  public static final Block RAINBOW_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block TRANS_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block NONBINARY_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block GENDERFLUID_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block BI_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block LESBIAN_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block ACE_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block ARO_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block PAN_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block POLY_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block AGENDER_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));
  public static final Block MLM_BLOCK = new Block(FabricBlockSettings.copy(Blocks.WHITE_WOOL));

  public static void registerFlagItems() {
    Registry.register(Registry.ITEM, new Identifier("prideflags", "rainbow_flag"), RAINBOW_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "trans_flag"), TRANS_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "nonbinary_flag"), NONBINARY_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "genderfluid_flag"), GENDERFLUID_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "bi_flag"), BI_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "lesbian_flag"), LESBIAN_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "ace_flag"), ACE_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "aro_flag"), ARO_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "pan_flag"), PAN_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "poly_flag"), POLY_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "agender_flag"), AGENDER_FLAG);
    Registry.register(Registry.ITEM, new Identifier("prideflags", "mlm_flag"), MLM_FLAG);
  }

  public static void registerPrideBlocks() {
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "rainbow_block"), RAINBOW_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "trans_block"), TRANS_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "nonbinary_block"), NONBINARY_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "genderfluid_block"), GENDERFLUID_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "bi_block"), BI_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "lesbian_block"), LESBIAN_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "ace_block"), ACE_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "aro_block"), ARO_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "pan_block"), PAN_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "poly_block"), POLY_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "agender_block"), AGENDER_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier("prideflags", "mlm_block"), MLM_BLOCK);
  }

  public static void registerPrideBlockitems() {
    Registry.register(Registry.ITEM, new Identifier("prideflags", "rainbow_block"), new BlockItem(RAINBOW_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "trans_block"), new BlockItem(TRANS_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "nonbinary_block"), new BlockItem(NONBINARY_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "genderfluid_block"), new BlockItem(GENDERFLUID_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "bi_block"), new BlockItem(BI_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "lesbian_block"), new BlockItem(LESBIAN_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "ace_block"), new BlockItem(ACE_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "aro_block"), new BlockItem(ARO_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "pan_block"), new BlockItem(PAN_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "poly_block"), new BlockItem(POLY_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "agender_block"), new BlockItem(AGENDER_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
    Registry.register(Registry.ITEM, new Identifier("prideflags", "mlm_block"), new BlockItem(MLM_BLOCK, new FabricItemSettings().group(PrideFlags.PRIDE_GROUP)));
  }
}
