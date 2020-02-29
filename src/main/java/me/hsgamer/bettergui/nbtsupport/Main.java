package me.hsgamer.bettergui.nbtsupport;

import de.tr7zw.changeme.nbtapi.utils.MinecraftVersion;
import me.hsgamer.bettergui.builder.PropertyBuilder;
import me.hsgamer.bettergui.nbtsupport.property.HideAttributes;
import me.hsgamer.bettergui.nbtsupport.property.NBT;
import me.hsgamer.bettergui.nbtsupport.property.Unbreakable;
import me.hsgamer.bettergui.object.addon.Addon;

public final class Main extends Addon {

  @Override
  public boolean onLoad() {
    MinecraftVersion.getVersion();
    PropertyBuilder.registerItemProperty("nbt-data", NBT.class);
    PropertyBuilder.registerItemProperty("nbt", NBT.class);
    PropertyBuilder.registerItemProperty("unbreakable", Unbreakable.class);
    PropertyBuilder.registerItemProperty("hide-attributes", HideAttributes.class);
    return true;
  }
}
