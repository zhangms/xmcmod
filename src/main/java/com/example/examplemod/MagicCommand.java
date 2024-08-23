package com.example.examplemod;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.logging.LogUtils;
import net.minecraft.commands.Commands;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.slf4j.Logger;

/**
 * @author ZMS
 * 2024/8/23 12:02
 */
@EventBusSubscriber(modid = ExampleMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class MagicCommand {


    public static final Logger LOGGER = LogUtils.getLogger();


    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {

        var magicCommandBuilder = Commands.literal("magic")
                .then(Commands.argument("content", StringArgumentType.greedyString())
                        .executes(context -> {
                            var content = StringArgumentType.getString(context, "content");
                            LOGGER.info("Magic command: {}", content);
                            return Command.SINGLE_SUCCESS;
                        }));

        event.getDispatcher().register(magicCommandBuilder);
    }

}
