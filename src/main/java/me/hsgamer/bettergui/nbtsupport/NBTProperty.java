package me.hsgamer.bettergui.nbtsupport;

import me.hsgamer.bettergui.object.Icon;
import me.hsgamer.bettergui.object.property.item.ItemProperty;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NBTProperty extends ItemProperty<String, String> {

  private boolean hasVariable = false;

  public NBTProperty(Icon icon) {
    super(icon);
  }

  @Override
  public void setValue(Object input) {
    super.setValue(input);
    hasVariable = getIcon().hasVariables(getValue());
  }

  @Override
  public String getParsed(Player player) {
    return hasVariable ? getIcon().setVariables(getValue(), player) : getValue();
  }

  @Override
  public ItemStack parse(Player player, ItemStack itemStack) {
    return Bukkit.getUnsafe().modifyItemStack(itemStack, getParsed(player));
  }

  @Override
  public boolean compareWithItemStack(Player player, ItemStack itemStack) {
    throw new UnsupportedOperationException("Not support comparing with the new method");
  }
}
