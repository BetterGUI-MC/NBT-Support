package me.hsgamer.bettergui.nbtsupport;

import me.hsgamer.bettergui.builder.PropertyBuilder;
import me.hsgamer.bettergui.object.addon.Addon;

public final class Main extends Addon {

  @Override
  public boolean onLoad() {
    getPlugin().getMessageConfig().getConfig()
        .addDefault("invalid-nbt-data", "&cCannot apply NBT data to the item. Inform the staff");
    return true;
  }

  @Override
  public void onEnable() {
    PropertyBuilder.registerItemProperty("nbt-data", NBTProperty.class);
    PropertyBuilder.registerItemProperty("nbt", NBTProperty.class);
  }
}
