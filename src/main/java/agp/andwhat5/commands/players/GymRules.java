package agp.andwhat5.commands.players;

import agp.andwhat5.Utils;
import agp.andwhat5.commands.Command;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class GymRules extends Command{

	public GymRules() {
		super("gymrules", "/GymRules <gym>");
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length != 1)
		{
			sender.sendMessage(Utils.toText("&7Incorrect Usage: /GymRules <Gym>", true));
			return;
		}
		if(!Utils.gymExists(args[0]))
		{
			sender.sendMessage(Utils.toText("&7This gym does not exist!", true));
			return;
		}
		if(Utils.getGym(args[0]).Rules == "")
		{
			sender.sendMessage(Utils.toText("&7This gym does not have any rules!", true));
			return;
		}
		String[] msg = Utils.getGym(args[0]).Rules.split("/n");
		for(String s : msg)
		{
			sender.sendMessage(Utils.toText("&7"+s, true));
		}
	}

}