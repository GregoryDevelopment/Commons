package gg.kisruimc.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class CommandManager {

    private JavaPlugin javaPlugin;

    private String noPermissionMessage;

    public CommandManager(JavaPlugin javaPlugin, String noPermissionMessage) {
        this.javaPlugin = javaPlugin;
        this.noPermissionMessage = noPermissionMessage;
    }

    public String getNoPermissionMessage() {
        return noPermissionMessage;
    }

    public void setNoPermissionMessage(String noPermissionMessage) {
        this.noPermissionMessage = noPermissionMessage;
    }

    public CommandManager(JavaPlugin javaPlugin) {
        this(javaPlugin, ChatColor.RED + "I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
    }

    public void registerCommands(final CommandListener commandListener) {
        List<Method> methods = getCommandMethods(commandListener.getClass());
        methods.forEach(method -> {

            final CommandHandler commandHandler = method.getAnnotation(CommandHandler.class);

            BukkitCommand bukkitCommand = new BukkitCommand(commandHandler.name()) {

                @Override
                public boolean execute(CommandSender commandSender, String s, String[] strings) {

                    if (!commandHandler.usage().equalsIgnoreCase("None")) {
                        String[] usage = commandHandler.usage().split(" ");

                        if (strings.length < usage.length) {
                            commandSender.sendMessage(ChatColor.RED + this.getUsage());
                            return true;
                        }
                    }

                    if (!commandHandler.permission().equalsIgnoreCase("None")) {
                        if (!commandSender.hasPermission(commandHandler.permission())) {
                            commandSender.sendMessage(noPermissionMessage);
                            return true;
                        }
                    }

                    try {
                        method.invoke(commandListener, commandSender, s, strings);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        javaPlugin.getLogger().log(Level.WARNING, "Failed registering command: " + commandHandler.name() + " Couldn't find the correct method with arguments (CommandSender.class, String.class, String[].class)");
                        return true;
                    }

                    return true;
                }
            };

            if (!commandHandler.aliases()[0].equalsIgnoreCase("None")) {
                bukkitCommand.setAliases(Arrays.asList(commandHandler.aliases()));
            }

            bukkitCommand.setDescription(commandHandler.description());

            if (!commandHandler.permission().equalsIgnoreCase("None")) {
                bukkitCommand.setPermission(commandHandler.permission());
            }

            if (!commandHandler.usage().equalsIgnoreCase("None")) {
                bukkitCommand.setUsage("/" + commandHandler.name() + " " + commandHandler.usage());
            }

            try {
                Field commandMap = javaPlugin.getServer().getClass().getDeclaredField("commandMap");

                commandMap.setAccessible(true);

                SimpleCommandMap simpleCommandMap = (SimpleCommandMap) commandMap.get(javaPlugin.getServer());
                simpleCommandMap.register(bukkitCommand.getName(), bukkitCommand);

                javaPlugin.getLogger().log(Level.INFO, "Registered command: " + bukkitCommand.getName());

                commandMap.setAccessible(false);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                javaPlugin.getLogger().log(Level.WARNING, "Failed registering command: " + commandHandler.name() + " error-message: " + e.getMessage());
            }

        });
    }

    private List<Method> getCommandMethods(final Class<?> type) {
        final List<Method> methods = new ArrayList<>();
        Class<?> clazz = type;

        while (clazz != Object.class) {
            final List<Method> allMethods = new ArrayList<>(Arrays.asList(clazz.getDeclaredMethods()));

            allMethods.forEach(method -> addCommandAnnotated(methods, method));

            clazz = clazz.getSuperclass();
        }

        return methods;
    }

    private List<Method> addCommandAnnotated(List<Method> base, Method method) {
        if (method.isAnnotationPresent(CommandHandler.class)) {
            base.add(method);
        }

        return base;
    }

}
