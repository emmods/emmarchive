/*
 * Copyright Emmaffle <chocobacon@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 * (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
 */

package coffee.waffle.chocobacon;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ChocolateMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {2, 4, 6, 2};

    @Override
    public int getDurability(EquipmentSlot slot) {
      return BASE_DURABILITY[slot.getEntitySlotId()] * 30;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
      return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
      return 1;
    }

    @Override
    public SoundEvent getEquipSound() {
      return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
      return Ingredient.ofItems(RegisterItems.CHOCOLATE);
    }

    @Override
    public String getName() {
      return "chocolate";
    }

    @Override
    public float getToughness() {
      return 1.0F;
    }

    @Override
    public float getKnockbackResistance() {
      return 0;
  }
}
