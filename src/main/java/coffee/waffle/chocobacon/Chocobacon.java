/*
 * Copyright Emmaffle <chocobacon@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 * (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
 */

package coffee.waffle.chocobacon;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chocobacon implements ModInitializer {
  public static final String MOD_ID = "chocobacon";
  public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

  // Declaring items
  public static final Item COOKED_BACON = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.85F).meat().build()));
  public static final Item CHOCOLATE_BAR = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.85F).build()));
  public static final Item CHOCOLATE_BACON = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(12).saturationModifier(1.3F).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5), 1F).build()));

  // Declaring blocks
  public static final Block CHOCOLATE_ORE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
  public static final Block BACON_ORE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));

  // Chocolate Ore Overworld
  private static final ConfiguredFeature<?, ?> CHOCOLATE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Chocobacon.CHOCOLATE_ORE.getDefaultState(), 7)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64))).spreadHorizontally().repeat(7);

  // Bacon Ore Nether
  private static final ConfiguredFeature<?, ?> BACON_ORE_NETHER = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, Chocobacon.BACON_ORE.getDefaultState(), 7)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64))).spreadHorizontally().repeat(7);

  @Override
  public void onInitialize() {
    // Registering items
    Registry.register(Registry.ITEM, new Identifier("chocobacon", "cooked_bacon"), COOKED_BACON);
    Registry.register(Registry.ITEM, new Identifier("chocobacon", "chocolate_bar"), CHOCOLATE_BAR);
    Registry.register(Registry.ITEM, new Identifier("chocobacon", "chocolate_bacon"), CHOCOLATE_BACON);

    // Registering blocks
    Registry.register(Registry.BLOCK, new Identifier("chocobacon", "chocolate_ore"), CHOCOLATE_ORE);
    Registry.register(Registry.BLOCK, new Identifier("chocobacon", "bacon_ore"), BACON_ORE);

    // Registering blockitems
    Registry.register(Registry.ITEM, new Identifier("chocobacon", "chocolate_ore"), new BlockItem(CHOCOLATE_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    Registry.register(Registry.ITEM, new Identifier("chocobacon", "bacon_ore"), new BlockItem(BACON_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

    // Registering Chocolate Ore veins
    RegistryKey<ConfiguredFeature<?, ?>> chocolateOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
            new Identifier("chocobacon", "chocolate_ore_overworld"));
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, chocolateOreOverworld.getValue(), CHOCOLATE_ORE_OVERWORLD);
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, chocolateOreOverworld);
    // Registering Bacon Ore veins
    RegistryKey<ConfiguredFeature<?, ?>> baconOreNether = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
            new Identifier("chocobacon", "bacon_ore_nether"));
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, baconOreNether.getValue(), BACON_ORE_NETHER);
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, baconOreNether);

    // Send confirmation to console
    LOGGER.info("Chocobacon has finished loading - enjoy yer bacon & chocolate :)");
  }
}
