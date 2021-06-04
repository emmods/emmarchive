/*
 Copyright Emmaffle <pridemcmod@waffle.coffee> 2021. Distributed under the Boost Software License, Version 1.0.
 (See accompanying file 'LICENSE' or copy at https://www.boost.org/LICENSE_1_0.txt)
*/

package coffee.waffle.prideflags;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;

public class PrideFlags implements ModInitializer {
  public static final String MODID = "prideflags";

  @Override
  public void onInitialize() {
    PrideFlagsRegistry.register();

    LogManager.getLogger(MODID).info("Pride Flags has finished loading! \uD83C\uDFF3\u200D\uD83C\uDF08");
  }
}
