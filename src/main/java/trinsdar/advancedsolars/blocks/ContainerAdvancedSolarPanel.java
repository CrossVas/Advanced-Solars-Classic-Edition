package trinsdar.advancedsolars.blocks;

import ic2.core.inventory.container.ContainerTileComponent;
import ic2.core.inventory.gui.GuiIC2;
import ic2.core.inventory.gui.components.base.GeneratorChargeComp;
import ic2.core.inventory.slots.SlotCharge;
import ic2.core.util.math.Box2D;
import ic2.core.util.math.Vec2i;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trinsdar.advancedsolars.util.AdvancedSolarEnergyStringComp;
import trinsdar.advancedsolars.util.AdvancedSolarPanelComp;

public class ContainerAdvancedSolarPanel extends ContainerTileComponent<TileEntityAdvancedSolarPanel> {

    public static Box2D solarPanelLightBox = new Box2D(126, 60, 14, 14);
    public static Box2D lunarPanelLightBox = new Box2D(144, 60, 14, 14);
    public static Vec2i daySolarLightPos = new Vec2i(178, 16);
    public static Vec2i nightSolarLightPos = new Vec2i(193, 16);
    public static Box2D chargeBox = new Box2D(91, 61, 24, 14);
    public static Vec2i chargePos = new Vec2i(178, 0);

    public ContainerAdvancedSolarPanel(InventoryPlayer player, TileEntityAdvancedSolarPanel tile) {
        super(tile);
        this.addSlotToContainer(new SlotCharge(tile, tile.tier, 0, 8, 59));
        this.addSlotToContainer(new SlotCharge(tile, tile.tier, 1, 26, 59));
        this.addSlotToContainer(new SlotCharge(tile, tile.tier, 2, 44, 59));
        this.addSlotToContainer(new SlotCharge(tile, tile.tier, 3, 62, 59));

        if (tile.skyBlockCheck()) {
            if (tile.isSunVisible()) {
                this.addComponent(new AdvancedSolarPanelComp(tile, solarPanelLightBox, daySolarLightPos));
            } else {
                this.addComponent(new AdvancedSolarPanelComp(tile, lunarPanelLightBox, nightSolarLightPos));
            }
        }
        this.addComponent(new AdvancedSolarEnergyStringComp(tile));
        this.addComponent(new GeneratorChargeComp(tile, chargeBox, chargePos));
        this.addPlayerInventory(player);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onGuiLoaded(GuiIC2 gui) {
        gui.dissableInvName();
        gui.disableName();
    }

    @Override
    public ResourceLocation getTexture() {
        return this.getGuiHolder().getTexture();
    }

    @Override
    public int guiInventorySize() {
        return this.getGuiHolder().slotCount;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.getGuiHolder().canInteractWith(playerIn);
    }

}
