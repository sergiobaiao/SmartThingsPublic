To make this work, you need to follow this:
1 - Create an account, if you don't have one, in the SmartThings Groovy IDE (https://graph.api.smartthings.com/)
2 - Link your Smartthings Hub, if it's not already linked, your account.
3 - Create a new SmartApp out of wakedevice.groovy code. To do this, go to your "MySmartApps" page, click on the "New SmartApp" button, choose "From Code", and then copy and paste the contents of this file there. Then click on "Create" button.
 4 - You now need to create a new Device Handler. Go to your "My Device Handlers" page, and click on "Create New Device Handler" button. Select the "From Code" option, then paste the code from togglebutton.groovy on the form, then click on the "Create" button
 5 - You now need to create a new Device that will control this SmartApp. Go to your "My Devices" page, click on the new "Create New Device" button, and follow this:

Name: Put a name for the Toggle Button, like "Turn on Kitchen TV"
Label: Put a label, can be the same as the Name
Zigbee Id: leave blank
Device Network ID: Give it an unique identifier, like "BUTWOLKTV"
Type: Select "Toggle Button"
Version: Published
Location: Choose the Location where your Smartthings Hub is. If you don't have one yet, go back and create one at "Locations" page. But 	you'll probably have one already, so, choose it.
Hub: Choose your Smartthings Hub
Group: Not available. Leave as is

Now click on "Create" button. Your newly created Virtual Switch will be shown at your "Devices" Page.

5 - Go back to your Smartthings app on your smartphone. Click on the 3 dash button on your top left, the choose SmartApps.
6 - Click on the "+" button to add a new SmartApp
7 - The SmartApp you previously created will be shown under "My SmartApps". Click on it, named "Wake Device"
8 - Click On the "Choose a Switch" section, and choose the Virtual Switch you just created.
9 - Under "MAC Address of device', input the device's MAC address in hexadecimal format, without any separators, like: aabbcc001122
10 - Give this SmartApp instance a name, like "Wake Kitchen TV", then click Save.
11 - A new switch will appear on your Dashboard. When you click on it, it will send a Magic Wake-on-Lan Packet to your device and, if everything is correctly configured (computers may need special configuration for this to work), your device will be turned on.
