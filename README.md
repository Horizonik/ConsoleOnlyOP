# ConsoleOnlyOP
Limit the /op command to the console only, no more malicious players insiding your server!

Worried of the possibility of someone gaining access to your server and /opping themselves? Or a malicious admin that decides to /op unwanted players?

Fear not, with ConsoleOnlyOP you can sleep soundly.

## Features

    Only console can now run the /op command.
    Anti Bypass Feature -> prevents players from using the /minecraft:op command instead.
    Configurable messages and prefix.

(Essentially a small plugin that limits access to the /op command to only the console, with a extra feature that blocks any default command bypasses).

Commands that this plugin blocks:
/minecraft:ban Player -> is blocked!
/essentials:ban Player -> is blocked!
/ban Player -> is allowed and completely fine.
(Works with any plugin name and any command)

[SPOILER="The Config File"]
[code=YAML]# The name of your server. Will appear before the message.
# Change it to "" if you don't want to use it.
prefix: "&7&bServer | "

# The message that shows up when a player tries to use the command /op name
# {player_name} is the name of the player that was entered in the /op command
NoPermissionsMessage: "&7{player_name} is not in the sudoers file. This incident will be reported."

# The message that shows up when a player is trying to bypass a default command.
# {original_command} is the command that was blocked, but without its plugin prefix.
# if -> /minecraft:op Player was entered, {original_command} will be -> /op Player

# For example, the command -> /minecraft:ban Player -> will be blocked!
# Or, the command -> /essentials:ban Player -> will be blocked!
# But using the command -> /ban Player -> is completely allowed
NoBypassMessage: "&7Sorry! Try using {original_command} instead!"[/code]
[/SPOILER]

Configuring the config

    Drop the .jar file into your plugins folder on your server, run or reload it and you'll then see a new folder inside your plugins folder that is called ConsoleOnlyOP, open the config.yml file and voila you can now change the responses to the players.

    Color codes work, so you can for example make your message be colored in red by using &4 in the config.
