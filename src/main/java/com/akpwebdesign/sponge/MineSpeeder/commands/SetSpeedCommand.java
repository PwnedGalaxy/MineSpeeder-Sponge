package com.akpwebdesign.sponge.MineSpeeder.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import com.akpwebdesign.sponge.MineSpeeder.MineSpeeder;

public class SetSpeedCommand implements CommandExecutor {
    
    public static CommandSpec commandSpec = CommandSpec.builder()
            .description(Text.of("Set the max speed of minecarts."))
            .permission("minespeeder.command.setspeed")
            .arguments(GenericArguments.onlyOne(GenericArguments.doubleNum(Text.of("speed"))))
            .executor(new SetSpeedCommand())
            .build();

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        double speed = (double) args.getOne("speed").get();
        
        MineSpeeder.getPlugin().setMaxSwiftness(speed);
        
        src.sendMessage(Text.of(TextColors.GREEN, "Minecart max speed set to " + speed + "!"));
        return CommandResult.success();
    }

}
