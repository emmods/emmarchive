/*
 * Copyright Emmaffle <chocobacon@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 * (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
 */

package coffee.waffle.chocobacon;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
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

public class ChocobaconRegistry {
  public static final String MODID = "chocobacon";
  public static final ArmorMaterial chocolateBarMaterial = new ChocolateBarMaterial();
  public static Item COOKED_BACON, CHOCOLATE_BAR, CHOCOLATE_BACON, CHOCOLATE_BUCKET;
  public static Block CHOCOLATE_ORE, BACON_ORE;
  public static FlowableFluid STILL_CHOCOLATE, FLOWING_CHOCOLATE;

  public static void register() {
    // Registering items
    COOKED_BACON = Registry.register(Registry.ITEM, new Identifier(MODID, "cooked_bacon"), new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.85F).meat().build())));
    CHOCOLATE_BAR = Registry.register(Registry.ITEM, new Identifier(MODID, "chocolate_bar"), new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.85F).build())));
    CHOCOLATE_BACON = Registry.register(Registry.ITEM, new Identifier(MODID, "chocolate_bacon"), new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(12).saturationModifier(1.3F).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5), 1F).build())));

    // Registering blocks
    CHOCOLATE_ORE = Registry.register(Registry.BLOCK, new Identifier(MODID, "chocolate_ore"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
    BACON_ORE = Registry.register(Registry.BLOCK, new Identifier(MODID, "bacon_ore"), new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));

    // Registering blockitems
    Registry.register(Registry.ITEM, new Identifier(MODID, "chocolate_ore"), new BlockItem(CHOCOLATE_ORE, new FabricItemSettings().group(Chocobacon.CHOCOBACON_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "bacon_ore"), new BlockItem(BACON_ORE, new FabricItemSettings().group(Chocobacon.CHOCOBACON_GROUP)));

    // Registering Chocolate Ore veins
    RegistryKey<ConfiguredFeature<?, ?>> chocolateOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
            new Identifier(MODID, "chocolate_ore_overworld"));
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, chocolateOreOverworld.getValue(), Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CHOCOLATE_ORE.getDefaultState(), 7)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64))).spreadHorizontally().repeat(7));
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, chocolateOreOverworld);

    // Registering Bacon Ore veins
    RegistryKey<ConfiguredFeature<?, ?>> baconOreNether = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
            new Identifier(MODID, "bacon_ore_nether"));
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, baconOreNether.getValue(), Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, BACON_ORE.getDefaultState(), 7)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64))).spreadHorizontally().repeat(7));
    BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, baconOreNether);

    // Registering Chocolate Armour
    Registry.register(Registry.ITEM, new Identifier(MODID, "chocolate_helmet"), new ArmorItem(chocolateBarMaterial, EquipmentSlot.HEAD, new FabricItemSettings().group(Chocobacon.CHOCOBACON_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "chocolate_chestplate"), new ArmorItem(chocolateBarMaterial, EquipmentSlot.CHEST, new FabricItemSettings().group(Chocobacon.CHOCOBACON_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "chocolate_leggings"), new ArmorItem(chocolateBarMaterial, EquipmentSlot.LEGS, new FabricItemSettings().group(Chocobacon.CHOCOBACON_GROUP)));
    Registry.register(Registry.ITEM, new Identifier(MODID, "chocolate_boots"), new ArmorItem(chocolateBarMaterial, EquipmentSlot.FEET, new FabricItemSettings().group(Chocobacon.CHOCOBACON_GROUP)));

    // Registering things related to Chocolate Fluid
    STILL_CHOCOLATE = Registry.register(Registry.FLUID, new Identifier(MODID, "still_chocolate"), new ChocolateFluid.Still());
    FLOWING_CHOCOLATE = Registry.register(Registry.FLUID, new Identifier(MODID, "flowing_chocolate"), new ChocolateFluid.Flowing());
    CHOCOLATE_BUCKET = Registry.register(Registry.ITEM, new Identifier(MODID, "chocolate_bucket"), new BucketItem(STILL_CHOCOLATE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(Chocobacon.CHOCOBACON_GROUP)));
  }
}
