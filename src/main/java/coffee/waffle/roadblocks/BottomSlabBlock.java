package coffee.waffle.roadblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BottomSlabBlock extends Block {
  public BottomSlabBlock(Settings settings) {
    super(settings);
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
    return VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.5f, 1f);
  }
}
