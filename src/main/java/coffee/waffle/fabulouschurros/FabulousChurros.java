// Licensed under the WTFWYEDTHSPL (see accompanying file `LICENSE.md`).

package coffee.waffle.fabulouschurros;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;

public class FabulousChurros implements ModInitializer {
  public static final String MODID = "fabulous-churros";

  @Override
  public void onInitialize() {
    ChurroRegistry.register();

    // Send confirmation to console
    LogManager.getLogger(MODID).info("FabulousChurros has finished loading - enjoy yer churros! :)");
  }
}
