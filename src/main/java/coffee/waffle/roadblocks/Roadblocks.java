package coffee.waffle.roadblocks;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Roadblocks implements ModInitializer {
  public static final String MODID = "roadblocks";
  public static final Logger LOGGER = LogManager.getLogger(MODID);

  @Override
  public void onInitialize() {
    RoadblocksRegistry.register();

    // Send confirmation to console
    LOGGER.info("Roadblocks has finished loading!");
  }
}
