/*
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not
 * distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0.
 *
 * This Source Code Form is "Incompatible With Secondary Licenses", as defined by the Mozilla Public License, v. 2.0.
 */

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
