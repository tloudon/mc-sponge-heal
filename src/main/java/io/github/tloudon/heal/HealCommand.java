package io.github.tloudon.heal;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.data.key.Keys;



public class HealCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

        if(src instanceof Player) {
            Player player = (Player) src;
            player.sendMessage(Text.of("Healing " + player.getName() + "!"));
            player.offer(Keys.HEALTH, player.get(Keys.MAX_HEALTH).get());
            player.offer(Keys.FOOD_LEVEL, 20);

        }
        else {
            src.sendMessage(Text.of("HEAL IS FOR PLAYERS ONLY!"));
        }
        return CommandResult.success();
    }
}
