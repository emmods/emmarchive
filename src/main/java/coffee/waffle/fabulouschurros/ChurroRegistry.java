// Licensed under the WTFWYEDTHSPL (see accompanying file `LICENSE.md`).

package coffee.waffle.fabulouschurros;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class ChurroRegistry {
  public static final String MODID = "fabulouschurros";
  public static Item PLAIN_CHURRO;

  public static void register() {
    ItemGroup CHURRO_GROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "churro_group")).icon(() -> new ItemStack(PLAIN_CHURRO)).build();

    PLAIN_CHURRO = Registry.register(Registry.ITEM, new Identifier(MODID, "plain_churro"), new Item(new FabricItemSettings().group(CHURRO_GROUP).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5F).build())));
    Item SPICY_CHURRO = Registry.register(Registry.ITEM, new Identifier(MODID, "spicy_churro"), new Item(new FabricItemSettings().group(CHURRO_GROUP).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 30), 1F).build())));
    Item JUMPING_CHURRO = Registry.register(Registry.ITEM, new Identifier(MODID, "jumping_churro"), new Item(new FabricItemSettings().group(CHURRO_GROUP).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 30), 1F).build())));

    Item CHOCOLATE_HELMET = Registry.register(Registry.ITEM, new Identifier(MODID, "churro_helmet"), new ArmorItem(new ChurroMaterial(), EquipmentSlot.HEAD, new FabricItemSettings().group(CHURRO_GROUP)));
    Item CHOCOLATE_CHESTPLATE = Registry.register(Registry.ITEM, new Identifier(MODID, "churro_chestplate"), new ArmorItem(new ChurroMaterial(), EquipmentSlot.CHEST, new FabricItemSettings().group(CHURRO_GROUP)));
    Item CHOCOLATE_LEGGINGS = Registry.register(Registry.ITEM, new Identifier(MODID, "churro_leggings"), new ArmorItem(new ChurroMaterial(), EquipmentSlot.LEGS, new FabricItemSettings().group(CHURRO_GROUP)));
    Item CHOCOLATE_BOOTS = Registry.register(Registry.ITEM, new Identifier(MODID, "churro_boots"), new ArmorItem(new ChurroMaterial(), EquipmentSlot.FEET, new FabricItemSettings().group(CHURRO_GROUP)));
  }
}
