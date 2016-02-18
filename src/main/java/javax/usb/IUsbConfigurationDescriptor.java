/*
 * Copyright (C) 1999 - 2001, International Business Machines
 * Corporation. All Rights Reserved. Provided and licensed under the terms and
 * conditions of the Common Public License:
 * http://oss.software.ibm.com/developerworks/opensource/license-cpl.html
 *
 * Copyright (C) 2014 Key Bridge LLC. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package javax.usb;

/**
 * Interface for a USB configuration descriptor.
 * <p>
 * The configuration descriptor describes information about a specific device
 * configuration. The descriptor contains a bConfigurationValue field with a
 * value that, when used as a parameter to the SetConfiguration() request,
 * causes the device to assume the described configuration.
 * <p>
 * See the USB 1.1 specification section 9.6.2.
 *
 * @author Dan Streetman
 */
public interface IUsbConfigurationDescriptor extends IUsbDescriptor {

  /**
   * Total length of data returned for this configuration. Includes the combined
   * length of all descriptors (configuration, interface, endpoint, and class-
   * or vendor-specific) returned for this configuration.
   *
   * @return This descriptor's wTotalLength.
   * @see javax.usb.util.UsbUtil#unsignedInt(short) This is unsigned.
   */
  public short wTotalLength();

  /**
   * Get this descriptor's bNumInterfaces.
   *
   * @return This descriptor's bNumInterfaces.
   * @see javax.usb.util.UsbUtil#unsignedInt(byte) This is unsigned.
   */
  public byte bNumInterfaces();

  /**
   * Number of interfaces supported by this configuration
   *
   * @return This descriptor's bConfigurationValue.
   * @see javax.usb.util.UsbUtil#unsignedInt(byte) This is unsigned.
   */
  public byte bConfigurationValue();

  /**
   * Value to use as an argument to the SetConfiguration() request to select
   * this configuration
   *
   * @return This descriptor's iConfiguration.
   * @see javax.usb.util.UsbUtil#unsignedInt(byte) This is unsigned.
   */
  public byte iConfiguration();

  /**
   * Configuration characteristics D7: D6: D5: D4...0: Reserved (set to one)
   * Self-powered Remote Wakeup Reserved (reset to zero) D7 is reserved and must
   * be set to one for historical reasons. A device configuration that uses
   * power from the bus and a local source reports a non-zero value in bMaxPower
   * to indicate the amount of bus power required and sets D6. The actual power
   * source at runtime may be determined using the GetStatus(DEVICE) request
   * (see Section 9.4.5). If a device configuration supports remote wakeup, D5
   * is set to one.
   *
   * @return This descriptor's bmAttributes.
   * @see javax.usb.util.UsbUtil#unsignedInt(byte) This is unsigned.
   */
  public byte bmAttributes();

  /**
   * Maximum power consumption of the USB device from the bus in this specific
   * configuration when the device is fully operational. Expressed in 2 mA units
   * (i.e., 50 = 100 mA).
   * <p>
   * Note: A device configuration reports whether the configuration is
   * bus-powered or self- powered. Device status reports whether the device is
   * currently self-powered. If a device is disconnected from its external power
   * source, it updates device status to indicate that it is no longer
   * self-powered.
   * <p>
   * A device may not increase its power draw from the bus, when it loses its
   * external power source, beyond the amount reported by its configuration.
   * <p>
   * If a device can continue to operate when disconnected from its external
   * power source, it continues to do so. If the device cannot continue to
   * operate, it fails operations it can no longer support. The USB System
   * Software may determine the cause of the failure by checking the status and
   * noting the loss of the device’s power source.
   *
   * @return This descriptor's bMaxPower in units of 2mA. This is unsigned.
   */
  public byte bMaxPower();
}
