/*
 * Copyright Emmaffle <chocobacon@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 * (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
 */

package coffee.waffle.chocobacon;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Chocobacon implements ModInitializer {
  public static final Item COOKED_BACON = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.85F).meat().build()));
  public static final Item CHOCOLATE_BAR = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.85F).build()));
  public static final Item CHOCOLATE_BACON = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(12).saturationModifier(1.3F).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5), 1F).build()));

  @Override
  public void onInitialize() {
    Registry.register(Registry.ITEM, new Identifier("chocobacon", "cooked_bacon"), COOKED_BACON);
    Registry.register(Registry.ITEM, new Identifier("chocobacon", "chocolate_bar"), CHOCOLATE_BAR);
    Registry.register(Registry.ITEM, new Identifier("chocobacon", "chocolate_bacon"), CHOCOLATE_BACON);
  }
}
