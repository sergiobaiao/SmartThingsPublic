/**
 *  Wake Device
 *
 *  Copyright 2020 Sergio Baiao
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  To make this work, you need to follow this:
 *  1 - Create an account, if you don't have one, in the SmartThings Groovy IDE (https://graph.api.smartthings.com/)
 *  2 - Link your Smartthings Hub, if it's not already linked, your account.
 *  3 - Create a new SmartApp out of this code. Go to your "MySmartApps" page, click on the "New SmartApp" button, 
 *      choose "From Code", and then copy and paste the contents of this file there. Then click on "Create" button.
 *  4 - You now need to create a new Device Handler. Go to your "My Device Handlers" page, and click on "Create New Device Handler"
        button. Select the "From Code" option, then open https://raw.githubusercontent.com/sergiobaiao/SmartThingsPublic/master/wakedevice/togglebutton.groovy 
		on your browser and copy and paste the code on the form, then click on the "Create" button
 *  4 - You now need to create a new Device that will control this SmartApp. Go to your "My Devices" page, click on
 *      the new "Create New Device" button, and follow this:
 *          Name: Put a name for the Toggle Button, like "Turn on Kitchen TV"
 *          Label: Put a label, can be the same as the Name
 *          Zigbee Id: leave blank
 *          Device Network ID: Give it an unique identifier, like "BUTWOLKTV"
 *          Type: Select "Toggle Button"
 *          Version: Published
 *          Location: Choose the Location where your Smartthings Hub is. If you don't have one yet, go back and create one
 *                    at "Locations" page. But you'll probably have one already, so, choose it.
 *          Hub: Choose your Smartthings Hub
 *          Group: Not available yet. After you create the Virtual Switch you can edit it and "move" it to a room using this.
 *      Now click on "Create" button. Your newly created Virtual Switch will be shown at your "Devices" Page.
 *   5 - Go back to your Smartthings app on your smartphone. Click on the 3 dash button on your top left, the choose SmartApps.
 *   6 - Click on the "+" button to add a new SmartApp
 *   7 - The SmartApp you previously created will be shown under "My SmartApps". Click on it, named "Wake Device"
 *   8 - Click On the "Choose a Switch" section, and choose the Virtual Switch you just created.
 *   9 - Under "MAC Address of device', input the device's MAC address in hexadecimal format, without any separators,
 *       like: aabbcc001122
 *   10 - Give this SmartApp instance a name, like "Wake Kitchen TV", then click Save.
 *   11 - A new switch will appear on your Dashboard. When you click on it, it will send a Magic Wake-on-Lan Packet to your device
 *        and, if everything is correctly configured (computers may need special configuration for this to work), your device will
 *        be turned on.
 */
definition(
    name: "Wake Device",
    namespace: "sergiobaiao",
    author: "Sergio Baiao",
    description: "Turn On device using Wake On LAN",
    category: "Convenience",
    iconUrl: "https://raw.githubusercontent.com/sergiobaiao/SmartThingsPublic/master/wakedevice/wakebutton.png",
    iconX2Url: "https://raw.githubusercontent.com/sergiobaiao/SmartThingsPublic/master/wakedevice/wakebutton.png",
    iconX3Url: "https://raw.githubusercontent.com/sergiobaiao/SmartThingsPublic/master/wakedevice/wakebutton.png")

preferences {    
    section("Choose Switch") {
    	input "myDevice", "capability.switch", required: true, title: "Choose a Virtual Switch"
        input "myMac", "text", required: true, title: "MAC Address of Device without separators"
    }
}

def installed() {
	log.debug "Installed with settings: ${settings}"
	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"
	unsubscribe()
	initialize()
}

def initialize() {
	subscribe(myDevice, "switch.on", myHandler)
}

def myHandler(evt) {
	log.info "${myDevice} activated"
    sendHubCommand(createWOL())
}

def createWOL(evt) {
    log.debug "Sending Magic Packet to: $myMac"
    def result = new physicalgraph.device.HubAction (
       	"wake on lan $myMac",
       	physicalgraph.device.Protocol.LAN,
       	null
    )    
    return result
}
