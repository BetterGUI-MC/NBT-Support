package me.hsgamer.bettergui.nbtsupport;

import me.hsgamer.bettergui.builder.PropertyBuilder;
import me.hsgamer.bettergui.object.addon.Addon;

public final class Main extends Addon {

  @Override
  public void onEnable() {
    PropertyBuilder.registerItemProperty("nbt-data", NBTProperty.class);
    PropertyBuilder.registerItemProperty("nbt", NBTProperty.class);
  }
}
