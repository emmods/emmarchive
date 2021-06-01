/*
 Copyright Emmaffle <pridemcmod@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
*/

package coffee.waffle.prideflags;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrideFlags implements ModInitializer {
  public static final String MODID = "prideflags";
  public static final Logger LOGGER = LogManager.getLogger(MODID);

  @Override
  public void onInitialize() {
    PrideFlagsRegistry.register();

    LOGGER.info("Pride Flags has finished loading! \uD83C\uDFF3️\u200D\uD83C\uDF08");
  }
}
