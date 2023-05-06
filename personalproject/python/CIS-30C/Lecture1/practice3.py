### CIS-30C PYTHON FOR CYSEC -- Kasey Nguyen ###

# UNIT 1 Lecture practice -- 1:52:43

#write a Python script using range() to search for a list of network protocols

network_protocols = ['TCP', 'IP', 'HTTP', 'FTP', 'DNS', 'SMTP', 'POP3', 'IMAP', 'SSH', 'SSL/TLS']
search_key = input("enter a network protocol: ").upper() 
found = False
for i in range(len(network_protocols)):
    if network_protocols[i] == search_key:
        found = True
        break
if found: 
    print("Element found at index", i)
else: 
    print("Element not found")