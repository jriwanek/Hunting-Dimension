package net.darkhax.huntingdim;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public enum Messages {

    CHANGER_INVALID_DIMENSION("changer.invalid.dim"),
    CHANGER_BIOME_EXISTS("changer.biome.exists"),
    CHANGER_SET_SELF("changer.set.self"),
    CHANGER_SET_WORLD("changer.set.world"),
    TELEPORTER_CANCELED("teleporter.canceled"),
    TELEPORTER_MOUNTED("teleporter.mounted");
    

    private final String key;
    private final boolean isChat;

    Messages (String key) {

        this(key, false);
    }

    Messages (String key, boolean isChat) {

        this.key = key;
        this.isChat = isChat;
    }

    public void sendMessage (EntityPlayer player, Object... args) {

        final ITextComponent text = new TextComponentTranslation("chat.huntingdim." + this.key, args);

        if (this.isChat) {

            player.sendMessage(text);
        }

        else {

            player.sendStatusMessage(text, true);
        }
    }
}