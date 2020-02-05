package me.hsgamer.bettergui.nbtsupport;

import java.util.logging.Level;
import me.hsgamer.bettergui.BetterGUI;
import me.hsgamer.bettergui.object.Icon;
import me.hsgamer.bettergui.object.property.item.ItemProperty;
import me.hsgamer.bettergui.util.CommonUtils;
import me.ialistannen.mininbt.ItemNBTUtil;
import me.ialistannen.mininbt.NbtParser;
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
    try {
      return ItemNBTUtil.setNBTTag(NbtParser.parse(getParsed(player)), itemStack);
    } catch (Exception e) {
      BetterGUI.getInstance().getLogger().log(Level.WARNING, "Error when parsing item: " + getValue(), e);
      CommonUtils.sendMessage(player,
          BetterGUI.getInstance().getMessageConfig().get(String.class, "invalid-nbt-data",
              "&cCannot apply NBT data to the item. Inform the staff"));
    }
    return itemStack;
  }

  @Override
  public boolean compareWithItemStack(Player player, ItemStack itemStack) {
    throw new UnsupportedOperationException("Not support comparing with the new method");
  }
}
