/*
 * Copyright Emmaffle <chocobacon@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 * (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
 */

package coffee.waffle.chocobacon;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public abstract class Fluids extends FlowableFluid {
  @Override
  public boolean matchesType(Fluid fluid) {
    return fluid == getStill() || fluid == getFlowing();
  }

  @Override
  protected boolean isInfinite() {
    return false;
  }

  @Override
  protected boolean canBeReplacedWith(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
    return false;
  }

  @Override
  protected int getFlowSpeed(WorldView worldView) {
    return 4;
  }

  @Override
  protected int getLevelDecreasePerBlock(WorldView worldView) {
    return 1;
  }

  @Override
  public int getTickRate(WorldView worldView) {
    return 50;
  }

  @Override
  protected float getBlastResistance() {
    return 100.0F;
  }
}