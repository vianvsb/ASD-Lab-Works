### CIS-30C PYTHON FOR CYSEC -- Kasey Nguyen ###

# UNIT 1 Lecture practice -- 1:06:36

# write a Python to declare a list of network devices and use common methods
# to accomplish the below tasks.
    # a. add a device to the list 
    # b. remove the first device from the list 
    # c. add a tuple seg1_switch = ['NETGEAR04', 'NETGEAR05'] to the list using extend()
    # d. add a tuple seg1_switch = ['NETGEAR04', 'NETGEAR05'] to the list using append()
    

network_devices = ['CodeWizard3000', 'PixelNinja42', 'BinaryBrainiac99']
print(network_devices)
print()

#adding a device 
network_devices.append('TechSvvyGuru07')
print(f"with added device : {network_devices}") 
print()

#removing the first device 
network_devices.pop(0)
print(f"with removed device : {network_devices}")
print()

seg1_switch = ('NETGEAR04', 'NETGEAR05')

#extend() = take out of the tuple and lists it
    #can be then sorted
network_devices.extend(seg1_switch)
print(f"extended: {network_devices}")
print()

#append() = keeps it as a tuple and nests it 
    #cannot be sorted as tuples are static/constant
network_devices.append(seg1_switch)
print(f"appended : {network_devices}")


