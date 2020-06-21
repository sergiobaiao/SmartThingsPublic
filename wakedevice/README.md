<a href="https://github.com/sergiobaiao/SmartThingsPublic/blob/master/wakedevice/"><img src="https://github.com/sergiobaiao/SmartThingsPublic/blob/master/wakedevice/wakebutton512.png" title="Wake Device" alt="Wake Device"></a>




# Wake Device

> Wake Device over LAN using Smartthings

> SmartApp and Device Handler

> samsung smartthings smartapp device handler wol wake on lan

**All working**

## Table of Contents (Optional)



- [Requirements](#requeriments)
- [Samsung and SmartThings Groovy IDE Account](#account)
- [Setup](#setup)
- [Support](#support)
- [License](#license)


---

## Requirements

- <a href="https://graph.api.smartthings.com/" target="_blank">`SmartThings Groovy IDE`</a> account is required to get started
- Your Smartthings `HUB` must be already linked to your account. If not, link it.
- You must have at least one location on your account. 

### Account

- To start working with SmartThings' SmartApps and everything else, you must have a Samsung Account. If you don't have one, you must create one at https://account.samsung.com/membership/intro first.
- Using your Samsung Account, login to <a href="https://graph.api.smartthings.com/" target="_blank">`SmartThings Groovy IDE`</a>. 
- If you haven't done yet, you need to setup GitHub integration. Follow <a href="https://docs.smartthings.com/en/latest/tools-and-ide/github-integration.html?highlight=github" target="_blank">THIS GUIDE</a>.

### Setup

- **Create a new SmartApp**
	- Go to your "MySmartApps" page, click on the "New SmartApp" button, choose "From Code", and then copy and paste
the contents of <a href="https://raw.githubusercontent.com/sergiobaiao/SmartThingsPublic/master/wakedevice/wakedevice.groovy" target="_blank">wakedevice.groovy</a> there. Then click on "Create" button.


- **Create a new Device Handler**
	- Go to your "My Device Handlers" page, and click on "Create New Device Handler" button. Select the "From Code" option, 
then paste the code from <a href="https://raw.githubusercontent.com/sergiobaiao/SmartThingsPublic/master/wakedevice/togglebutton.groovy" target="_blank">togglebutton.groovy</a> on the form, then click on the "Create" button.

- **Create a new Device**
	- You now need to create a new Device that will control this SmartApp. Go to your "My Devices" page, click on the new "Create New Device" button, and follow this:

	- Name: Put a name for the Toggle Button, like "Turn on Kitchen TV"
	- Label: Put a label, can be the same as the Name
	- Zigbee Id: leave blank
	- Device Network ID: Give it an unique identifier, like "BUTWOLKTV"
	- Type: Select "Toggle Button"
	- Version: Published
	- Location: Choose the Location where your Smartthings Hub 
	- Hub: Choose your Smartthings Hub
	- Group: Not available. Leave as is

Now click on "Create" button. Your newly created Toggle Button will be shown at your "Devices" Page.

- **Smarthings App Configuration**
	- Go back to your Smartthings app on your smartphone. Click on the 3 dash button on your top left, the choose SmartApps.
	- Click on the "+" button to add a new SmartApp
	- The SmartApp you previously created will be shown under "My SmartApps". Click on it, named "Wake Device"
	- Click On the "Choose a Switch" section, and choose the Toggle Button you just created.
	- Under "MAC Address of device', input the device's MAC address in hexadecimal format, without any separators, like: aabbcc001122
	- Give this SmartApp instance a name, like "Wake Kitchen TV", then click Save.
	- A new switch will appear on your Dashboard. When you click on it, it will send a Magic Wake-on-Lan Packet to your device and, if everything is correctly configured (computers may need special configuration for this to work), your device will be turned on.

---

## Support

Reach out to me at one of the following places!

- Twitter at <a href="http://twitter.com/sergiobaiao" target="_blank">`@sergiobaiao`</a>

---

## License

[![License](http://img.shields.io/:license-Apache-blue.svg?style=flat-square)](http://www.apache.org/licenses/LICENSE-2.0)

- **[Apache License](http://www.apache.org/licenses/LICENSE-2.0)**
- Copyright 2020 © <a href="http://twitter.com/sergiobaiao" target="_blank">sergiobaiao</a>.
