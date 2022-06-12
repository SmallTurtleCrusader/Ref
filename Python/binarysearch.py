lst = [1,3,2,7,5,8,10,9,4,6]
lst.sort()
first = 0
last = len(lst)-1
mid = (first+last)//2
item = int(input("number to search: "))
found = False
while (first<=last and not found):
    mid = (first+last)//2
    if lst[mid] == item:
        print(f"found at location {mid}")
        found = True
    else:
        if item < lst[mid]:
            last = mid - 1
        else:
            first = mid + 1
if found == False:
    print("Number not found")

def binarysearch(list, item):
    lst = list
    lst.sort()
    first = 0
    last = len(lst)-1
    mid = (first+last)//2
    i = item
    found = False
    while (first<=last and not found):
        mid = (first+last)//2
        if lst[mid] == i:
            print(f"found at location {mid}")
            found = True
        else:
            if i < lst[mid]:
                last = mid - 1
            else:
                first = mid + 1
    if found == False:
        print("Number not found")

#binarysearch([1,2,3,4,5], 4)

print(f"List: {lst}")