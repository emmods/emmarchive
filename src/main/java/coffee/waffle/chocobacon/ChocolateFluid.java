/*
 * Copyright Emmaffle <chocobacon@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 * (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
 */

package coffee.waffle.chocobacon;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

import static coffee.waffle.chocobacon.Chocobacon.CHOCOLATE_FLUID;
import static coffee.waffle.chocobacon.ChocobaconRegistry.*;

public abstract class ChocolateFluid extends Fluids {
  @Override
  public Fluid getStill() {
    return STILL_CHOCOLATE;
  }

  @Override
  public Fluid getFlowing() {
    return FLOWING_CHOCOLATE;
  }

  @Override
  public Item getBucketItem() {
    return CHOCOLATE_BUCKET;
  }

  @Override
  protected BlockState toBlockState(FluidState fluidState) {
    return CHOCOLATE_FLUID.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
  }

  public static class Flowing extends ChocolateFluid {
    @Override
    protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
      super.appendProperties(builder);
      builder.add(LEVEL);
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
      // Do nothing
    }

    @Override
    public int getLevel(FluidState fluidState) {
      return fluidState.get(LEVEL);
    }

    @Override
    public boolean isStill(FluidState fluidState) {
      return false;
    }
  }

  public static class Still extends ChocolateFluid {
    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
      // Do nothing
    }

    @Override
    public int getLevel(FluidState fluidState) {
      return 8;
    }

    @Override
    public boolean isStill(FluidState fluidState) {
      return true;
    }
  }
}