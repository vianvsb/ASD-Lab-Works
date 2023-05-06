#declaring varibles 
my_name = "vian sebastian"
print(my_name)

student_name = "john smith"
print(student_name)

#declaring lists 
    #lists can contain multiple data types

name_list = ['physics', 3.89, 'a']
for i in name_list: print(i)

    # append(): add item to a list
name_list.append(365)
print(name_list)

    #insert(): add item to a list on a specific index
name_list.insert(2, "cherry")
print(name_list)

    #extend(): append elements from another list to the current list 
fruit_list = ["banana", "papaya", "blackcurrant"]
name_list.extend(fruit_list)
print(name_list)

    #index(): returns the index of the specified thing in a list
    #returns ValueError if none found
x = print(fruit_list.index("banana"))

    #remove(): remove the first item whose value is equal to x 
    #returns ValueError if no such item exists
fruit_list.remove("papaya")
print(fruit_list)

