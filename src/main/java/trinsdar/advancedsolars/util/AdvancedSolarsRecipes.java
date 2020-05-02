package trinsdar.advancedsolars.util;

import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.core.block.machine.low.TileEntityCompressor;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.ForgeRegistry;

public class AdvancedSolarsRecipes {
    public static void init(){
        initCraftingRecipes();
        initMiscRecipes();
    }

    static ICraftingRecipeList recipes = ClassicRecipes.advCrafting;

    public static void initCraftingRecipes() {
    	if (AdvancedSolarsConfig.enabledItems.disableIC2CompactedSolarPanels) {
    		removeRecipe("ic2", "shaped_tile.blockSolarLV_-1293705004");
    		removeRecipe("ic2", "shaped_tile.blockSolarMV_1807852596");
    		removeRecipe("ic2", "shaped_tile.blockSolarHV_-965625513");
    	}
    	if (AdvancedSolarsConfig.enabledItems.enableMiscCraftingItems) {
    		recipes.addRecipe(new ItemStack(Registry.irradiantUranium), " G ", "GUG", " G ", 'G', Items.GLOWSTONE_DUST, 'U', "ingotUranium");
    		recipes.addRecipe(new ItemStack(Registry.irradiantGlassPane, 6, 0), "RRR", "UGU", "RRR", 'R', Ic2Items.reinforcedGlass, 'U', Registry.irradiantUranium, 'G', Items.GLOWSTONE_DUST);
    		recipes.addRecipe(new ItemStack(Registry.irradiantGlassPane, 6, 0), "RUR", "RGR", "RUR", 'R', Ic2Items.reinforcedGlass, 'U', Registry.irradiantUranium, 'G', Items.GLOWSTONE_DUST);
    		recipes.addRecipe(new ItemStack(Registry.iridiumIronPlate), "RRR", "RIR", "RRR", 'R', Ic2Items.refinedIronIngot, 'I', "ingotIridium");
    		recipes.addRecipe(new ItemStack(Registry.reinforcedIridiumIronPlate), "ACA", "CPC", "ACA", 'A', Ic2Items.advancedAlloy, 'C', Ic2Items.carbonPlate, 'P', Registry.iridiumIronPlate);
    		recipes.addRecipe(new ItemStack(Registry.irradiantReinforcedPlate), "RSR", "LIL", "RDR", 'R', Items.REDSTONE, 'S', Registry.sunnariumPart, 'L', new ItemStack(Items.DYE, 1, 4), 'I', Registry.reinforcedIridiumIronPlate, 'D', "gemDiamond");
    		recipes.addRecipe(new ItemStack(Registry.sunnariumPart), "UGU", 'U', Ic2Items.uuMatter, 'G', Items.GLOWSTONE_DUST);
    		recipes.addRecipe(new ItemStack(Registry.sunnarium), "UUU", "GGG", "UUU", 'U', Ic2Items.uuMatter, 'G', Items.GLOWSTONE_DUST);
    		recipes.addRecipe(new ItemStack(Registry.sunnariumAlloy), "III", "ISI", "III", 'I', Ic2Items.iridiumPlate, 'S', Registry.sunnarium);
    		recipes.addRecipe(new ItemStack(Registry.enrichedSunnarium), "UUU", "USU", "UUU", 'U', Registry.irradiantUranium, 'S', Registry.sunnarium);
    		recipes.addRecipe(new ItemStack(Registry.enrichedSunnariumAlloy), " S ", "SAS", " S ", 'S', Registry.enrichedSunnarium, 'A', Registry.sunnariumAlloy);
    		recipes.addRecipe(new ItemStack(Registry.quantumCore), "SNS", "NEN", "SNS", 'S', Registry.enrichedSunnariumAlloy, 'N', Items.NETHER_STAR, 'E', Items.ENDER_EYE);
    		if (AdvancedSolarsConfig.enabledItems.enableAdvancedSolarPanel) {
    			recipes.addRecipe(new ItemStack(Registry.advancedSolarPanel), "GGG", "ASA", "CPC", 'G', Registry.irradiantGlassPane, 'A', Ic2Items.advancedAlloy, 'S', Ic2Items.solarPanel, 'C', "circuitAdvanced", 'P', Registry.irradiantReinforcedPlate);
    			if (AdvancedSolarsConfig.enabledItems.enableAdvancedSolarHelmet) {
    				recipes.addRecipe(new ItemStack(Registry.advancedSolarHelmet), " S ", "CHC", "GTG", 'S', Registry.advancedSolarPanel, 'C', "circuitAdvanced", 'H', Ic2Items.nanoHelmet, 'G', Ic2Items.doubleInsulatedGoldCable, 'T', Ic2Items.transformerLV);
    			}
    			if (AdvancedSolarsConfig.enabledItems.enableHybridSolarPanel) {
    				recipes.addRecipe(new ItemStack(Registry.hybridSolarPanel), "CLC", "IAI", "cSc", 'C', Ic2Items.carbonPlate, 'L', Blocks.LAPIS_BLOCK, 'I', Ic2Items.iridiumPlate, 'A', Registry.advancedSolarPanel, 'c', "circuitAdvanced", 'S', Registry.enrichedSunnarium);
    				if (AdvancedSolarsConfig.enabledItems.enableAdvancedSolarHelmet) {
    					recipes.addRecipe(new ItemStack(Registry.hybridSolarHelmet), " S ", "CQC", "GTG", 'S', Registry.hybridSolarPanel, 'C', "circuitAdvanced", 'Q', Ic2Items.quantumHelmet, 'G', Ic2Items.glassFiberCable, 'T', Ic2Items.transformerHV);
    				}
    				if (AdvancedSolarsConfig.enabledItems.enableUltimateHybridSolarPanel) {
        				recipes.addRecipe(new ItemStack(Registry.ultimateHybridSolarPanel), " L ", "CAC", "SCS", 'L', Blocks.LAPIS_BLOCK, 'C', Ic2Items.coalChunk, 'A', Registry.advancedSolarPanel, 'S', Registry.enrichedSunnariumAlloy);
        				recipes.addRecipe(new ItemStack(Registry.ultimateHybridSolarPanel), "HHH", "HCH", "HHH", 'H', Registry.hybridSolarPanel, 'C', "circuitAdvanced");
        				recipes.addShapelessRecipe(new ItemStack(Registry.hybridSolarPanel, 8, 0), Registry.ultimateHybridSolarPanel);
        				if (AdvancedSolarsConfig.enabledItems.enableUltimateHybridSolarHelmet) {
        					recipes.addRecipe(new ItemStack(Registry.ultimateHybridSolarHelmet), " S ", "CQC", "GTG", 'S', Registry.ultimateHybridSolarPanel, 'C', "circuitAdvanced", 'Q', Ic2Items.quantumHelmet, 'G', Ic2Items.glassFiberCable, 'T', Ic2Items.transformerHV);	
        					recipes.addShapelessRecipe(new ItemStack(Registry.ultimateHybridSolarHelmet), Registry.hybridSolarHelmet, Registry.ultimateHybridSolarPanel);
        				}
        				if (AdvancedSolarsConfig.enabledItems.enableQuantumSolarPanel) {
        					recipes.addRecipe(new ItemStack(Registry.quantumSolarPanel), "UUU", "UCU", "UUU", 'U', Registry.ultimateHybridSolarPanel, 'C', Registry.quantumCore);
        					recipes.addShapelessRecipe(new ItemStack(Registry.ultimateHybridSolarPanel, 8, 0), Registry.quantumSolarPanel);
        				}
        			}
    			}
    		}
    	}
    }

    public static void initMiscRecipes(){
        OreDictionary.registerOre("ingotIridium", Registry.iridiumIngot);
        if (!Loader.isModLoaded("gtclassic") && !Loader.isModLoaded("techreborn")){
            TileEntityCompressor.addRecipe(Ic2Items.iridiumOre, new ItemStack(Registry.iridiumIngot));
        }
    }
    
	public static void removeRecipe(String modid, String recipeId) {
		((ForgeRegistry<?>) ForgeRegistries.RECIPES).remove(new ResourceLocation(modid, recipeId));
	}

}
