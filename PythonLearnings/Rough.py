
print ("My name is %s and my age is %d" %("Thivi", 25))

a = "  This is my email id xyz@gmail.com  "
list = a.split(" ")
print(list)

print (a.strip())

#Recurssion function for factorial
def fact(num):
    if num>1:
        num = num * fact(num-1)
    return num
print (fact(4))