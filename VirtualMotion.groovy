/**
 *  Virtual Motion Sensor
 *
 *  Copyright 2014 obycode
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
 */
metadata {
  definition (name: "Virtual Motion Sensor", namespace: "com.obycode", author: "obycode") {
    capability "Motion Sensor"
        command "open"
        command "close"
  }

  simulator {
    // TODO: define status and reply messages here
  }

  tiles {
    standardTile("motion", "device.motion", width: 2, height: 2, canChangeIcon: true) {
            state "inactive", icon: "st.motion.motion.inactive", backgroundColor: "#79b821"
             state "active", icon: "st.motion.motion.active", backgroundColor: "#ffa81e"
    }
        main "motion"
    details(["motion"])
  }
}

// parse events into attributes
def parse(String description) {
  log.debug "Virtual Motion Parsing '${description}'"
    // initialize to closed state
    if (description == "updated") {
      sendEvent(name: "motion", value: "inactive")
    }
}

def open() {
  sendEvent(name: "motion", value: "active")
}

def close() {
  sendEvent(name: "motion", value: "inactive")
}
