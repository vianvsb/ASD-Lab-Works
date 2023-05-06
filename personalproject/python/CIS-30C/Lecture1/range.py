### CIS-30C PYTHON FOR CYSEC -- Kasey Nguyen ###

# UNIT 1 Lecture practice -- 1:45:49 

#x = range(6) 
#for n in x: 
#    print(n)
    
#another example 
num_list = [2, 14, 65, 1, 799, 55, 82]
key = 2
found = False
for i in range(len(num_list)):
    if num_list[i] == key: 
        found = True 
        break 
if found: 
    print("found at index", i)
else: 
    print("not found")
        
    