package coffee.waffle.prideflags;

/*
 Copyright Emmaffle <pridemcmod@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
*/

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

public class PrideFlags implements ModInitializer {
    public static final ItemGroup PRIDE_GROUP = FabricItemGroupBuilder.create(
            new Identifier("prideflags", "flags"))
            .icon(() -> new ItemStack(PrideFlags.RAINBOW_FLAG))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(PrideFlags.RAINBOW_FLAG));
            })
            .build();

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

    @Override
    public void onInitialize() {
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

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("itemGroup.prideflags.flags"));
        tooltip.add(new TranslatableText("item.prideflags.rainbow_flag"));
        tooltip.add(new TranslatableText("item.prideflags.trans_flag"));
        tooltip.add(new TranslatableText("item.prideflags.nonbinary_flag"));
        tooltip.add(new TranslatableText("item.prideflags.genderfluid_flag"));
        tooltip.add(new TranslatableText("item.prideflags.bi_flag"));
        tooltip.add(new TranslatableText("item.prideflags.lesbian_flag"));
        tooltip.add(new TranslatableText("item.prideflags.ace_flag"));
        tooltip.add(new TranslatableText("item.prideflags.aro_flag"));
        tooltip.add(new TranslatableText("item.prideflags.pan_flag"));
        tooltip.add(new TranslatableText("item.prideflags.poly_flag"));
        tooltip.add(new TranslatableText("item.prideflags.agender_flag"));
        tooltip.add(new TranslatableText("item.prideflags.mlm_flag"));
    }
}
