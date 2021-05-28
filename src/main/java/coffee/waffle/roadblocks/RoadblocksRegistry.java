/*
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not
 * distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0.
 *
 * This Source Code Form is "Incompatible With Secondary Licenses", as defined by the Mozilla Public License, v. 2.0.
 */

package coffee.waffle.roadblocks;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RoadblocksRegistry {
  public static final String MODID = "roadblocks";

  public static ItemGroup ROADBLOCKS_GROUP;
  public static Item CONSTRUCTION_AGGREGATE, CEMENT, ASPHALT, ASPHALT_CONCRETE, WHITE_PAINT, YELLOW_PAINT;
  public static Block PLAIN_ASPHALT_ROAD, DOTTED_WHITE_PAINTED_ASPHALT_ROAD, DOTTED_YELLOW_PAINTED_ASPHALT_ROAD, SOLID_WHITE_PAINTED_ASPHALT_ROAD, SOLID_YELLOW_PAINTED_ASPHALT_ROAD, ONE_SIDE_SOLID_WHITE_PAINTED_ASPHALT_ROAD, ONE_SIDE_SOLID_YELLOW_PAINTED_ASPHALT_ROAD, ONE_SIDE_DOTTED_WHITE_PAINTED_ASPHALT_ROAD, ONE_SIDE_DOTTED_YELLOW_PAINTED_ASPHALT_ROAD;

  public static void register() {
    ROADBLOCKS_GROUP = FabricItemGroupBuilder.create(new Identifier(MODID, MODID + "group")).icon(() -> new ItemStack(ASPHALT)).build();

    CONSTRUCTION_AGGREGATE = Registry.register(Registry.ITEM, new Identifier(MODID, "construction_aggregate"), new Item(new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    CEMENT = Registry.register(Registry.ITEM, new Identifier(MODID, "cement"), new Item(new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    ASPHALT = Registry.register(Registry.ITEM, new Identifier(MODID, "asphalt"), new Item(new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    ASPHALT_CONCRETE = Registry.register(Registry.ITEM, new Identifier(MODID, "asphalt_concrete"), new Item(new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    WHITE_PAINT = Registry.register(Registry.ITEM, new Identifier(MODID, "white_paint"), new Item(new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    YELLOW_PAINT = Registry.register(Registry.ITEM, new Identifier(MODID, "yellow_paint"), new Item(new FabricItemSettings().group(ROADBLOCKS_GROUP)));

    PLAIN_ASPHALT_ROAD = Registry.register(Registry.BLOCK, new Identifier(MODID, "plain_asphalt_road"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    DOTTED_WHITE_PAINTED_ASPHALT_ROAD = Registry.register(Registry.BLOCK, new Identifier(MODID, "dotted_white_painted_asphalt_road"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    DOTTED_YELLOW_PAINTED_ASPHALT_ROAD = Registry.register(Registry.BLOCK, new Identifier(MODID, "dotted_yellow_painted_asphalt_road"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    SOLID_WHITE_PAINTED_ASPHALT_ROAD = Registry.register(Registry.BLOCK, new Identifier(MODID, "solid_white_painted_asphalt_road"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    SOLID_YELLOW_PAINTED_ASPHALT_ROAD = Registry.register(Registry.BLOCK, new Identifier(MODID, "solid_yellow_painted_asphalt_road"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    ONE_SIDE_SOLID_WHITE_PAINTED_ASPHALT_ROAD = Registry.register(Registry.BLOCK, new Identifier(MODID, "one_side_solid_white_painted_asphalt_road"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    ONE_SIDE_SOLID_YELLOW_PAINTED_ASPHALT_ROAD = Registry.register(Registry.BLOCK, new Identifier(MODID, "one_side_solid_yellow_painted_asphalt_road"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    ONE_SIDE_DOTTED_WHITE_PAINTED_ASPHALT_ROAD = Registry.register(Registry.BLOCK, new Identifier(MODID, "one_side_dotted_white_painted_asphalt_road"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    ONE_SIDE_DOTTED_YELLOW_PAINTED_ASPHALT_ROAD = Registry.register(Registry.BLOCK, new Identifier(MODID, "one_side_dotted_yellow_painted_asphalt_road"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    // TODO: add corners; other road materials; sealcoat; accessories to the road

    Registry.register(Registry.ITEM, new Identifier(MODID, "plain_asphalt_road"), new BlockItem(PLAIN_ASPHALT_ROAD, new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "dotted_white_painted_asphalt_road"), new BlockItem(DOTTED_WHITE_PAINTED_ASPHALT_ROAD, new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "dotted_yellow_painted_asphalt_road"), new BlockItem(DOTTED_YELLOW_PAINTED_ASPHALT_ROAD, new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "solid_white_painted_asphalt_road"), new BlockItem(SOLID_WHITE_PAINTED_ASPHALT_ROAD, new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "solid_yellow_painted_asphalt_road"), new BlockItem(SOLID_YELLOW_PAINTED_ASPHALT_ROAD, new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "one_side_solid_white_painted_asphalt_road"), new BlockItem(ONE_SIDE_SOLID_WHITE_PAINTED_ASPHALT_ROAD, new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "one_side_solid_yellow_painted_asphalt_road"), new BlockItem(ONE_SIDE_SOLID_YELLOW_PAINTED_ASPHALT_ROAD, new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "one_side_dotted_white_painted_asphalt_road"), new BlockItem(ONE_SIDE_DOTTED_WHITE_PAINTED_ASPHALT_ROAD, new FabricItemSettings().group(ROADBLOCKS_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "one_side_dotted_yellow_painted_asphalt_road"), new BlockItem(ONE_SIDE_DOTTED_YELLOW_PAINTED_ASPHALT_ROAD, new FabricItemSettings().group(ROADBLOCKS_GROUP)));
  }
}
