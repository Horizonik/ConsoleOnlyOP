# ConsoleOnlyOP
Limit the /op command to the console only, no more malicious players insiding your server!
Worried of the possibility of someone gaining access to your server and /opping themselves? Or a malicious admin that decides to /op unwanted players?
Fear not, with ConsoleOnlyOP you can sleep soundly.

## Features

- Only console can now run the /op command.
- Anti bypass that prevents players from using the /minecraft:op command instead.
- Configurable messages and prefix.

Essentially a small plugin that limits access to the /op command to only the console, with an extra feature that blocks any default command bypasses.

## Commands that this plugin blocks:
- /minecraft:ban Player -> is blocked!
- /essentials:ban Player -> is blocked!
- /ban Player -> is allowed and completely fine.
(Works with any plugin name and any command)

## Configuring the config
- Drop the .jar file into your plugins folder on your server, run or reload it and you'll then see a new folder inside your plugins folder that is called ConsoleOnlyOP, open the config.yml file and voila you can now change the responses to the players.

- Color codes work, so you can for example make your message be colored in red by using &4 in the config.
