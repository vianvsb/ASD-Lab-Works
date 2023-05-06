### CIS-30C PYTHON FOR CYSEC -- Kasey Nguyen ###

# UNIT 1 Lecture practice -- 1:22:24 

#refer to Python Documentation for built-in list methods and write 
#a Python script to accomplish the folloeiwng tasks 
    # a. Sort the list created in practice1 including step c. *sort() cannot sort tuple. Display list.
    # b. Count the number of times 'NETGEAR05' appears iin the list in practice1. Display count value.
    # c. Return the index of 'NETGEAR04'. Display index. 
    # d. Display the last item in the list using list index. 
    # e. Insert 'Linksys12' as the 4th item in the list 
    # f. Displat reversed list. 
    # g. Clear list. 
    
network_devices = ['CodeWizard3000', 'PixelNinja42', 'BinaryBrainiac99']
print(network_devices)
print()

seg1_switch = ('NETGEAR04', 'NETGEAR05')
network_devices.extend(seg1_switch)
print(f"extended: {network_devices}")
print()

#sort()
network_devices.sort()
print(f"sorted : {network_devices}")
print()

#count()
print(f"'NETGEAR05' count: {network_devices.count('NETGEAR05')}")
print()

#index()
print(f"'NETGEAR04' index : {network_devices.index('NETGEAR04')}")
print()

#display last item 
print(f"last item : {network_devices[-1]}")
print()

#bonus: print a range of devices (second to last items)
print(network_devices[1:]) #??
print()

#add 4th item 
network_devices.insert(3, 'Linksys12')
print(network_devices)
print()

#reverse list 
network_devices.reverse()
print(network_devices)
print()

#clear list
network_devices.clear()
print(network_devices)