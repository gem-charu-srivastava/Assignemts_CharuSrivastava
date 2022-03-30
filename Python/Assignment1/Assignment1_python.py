#Ques 1)
#a)

"""a=[1,2,3,4,5,6,7,8,9]
print(a[::2])

output=[1, 3, 5, 7, 9]"""

#b)
"""def f(value, values):
    v = 1
    values[0] = 44
    t = 3
    v = [1, 2, 3]
    f(t, v)
    print(t, v[0])

    output = No output"""

#c)
data=[[[1,2],[3,4]],[[5,6],[7,8]]]
def fun(m):
    v=m[0][0]
    for row in m:
        for element in row:
            if v< element:
                v=element
                return v
            print(fun(data[0]))

            
            

            

#-----------------------------------------------------------------------

#Ques2)
"""l1=[1,2,3,4,5,6]
#del l1[0]
#print (l1)"""

#-----------------------------------------------------------------------

#Ques3)

"""T1 = (23, 32, 4, 5, 2, 12, 23, 7, 9, 10, 23)
t=( )
for i in range(3):
    n = int(input("Enter number : "))
     t=t+(n,)
T1=T1 + t
print(T1)"""


#----------------------------------------------------------------------

#Ques 4) How to remove all items at once from dictionary?

"""Ans : The clear() method removes all items from the dictionary."""

#----------------------------------------------------------------------

#Ques 5)Write a Python script to sort (ascending and descending) a dictionary by value.

"""import operator
dic = {1: 2, 3: 4, 4: 3, 2: 1, 0: 0}
print('Original dictionary : ',dic)
sorted_dic = sorted(dic.items(), key=operator.itemgetter(1))
print('Dictionary in ascending order by value : ',sorted_dic)
sorted_dic = dict( sorted(dic.items(), key=operator.itemgetter(1),reverse=True))
print('Dictionary in descending order by value : ',sorted_dic)"""

#----------------------------------------------------------------------------------------

#Ques 6)Write a Python script to print a dictionary where the keys are numbers between 1 and 15 (both included) and the values are square of keys.

"""d=dict()
for x in range(1,16):
    d[x]=x**2
print(d)"""

#-----------------------------------------------------------------------------------------

#Ques 7) Write a programto find the sum of the digits of a number accepted from user.

"""num=int(input("Enter a number:"))
sum=0
while(num>0):
    r=num%10
    sum=sum+r
    num=num//10
print("Sum of digits is:" , sum)"""

#------------------------------------------------------------------------------------------

#Ques 8)Write a Python program to construct the following pattern, using a nested for loop.

"""n=5;
for i in range(n):
    for j in range(i):
        print ('* ', end="")
    print('')

for i in range(n,0,-1):
    for j in range(i):
        print('* ', end="")
    print('')"""

#------------------------------------------------------------------------------------------

#Ques 9)Write a program to read first 10 characters from a file named “data.txt”

"""f=open("data.txt",'r')
l=f.read(10)
print (l)"""

#-------------------------------------------------------------------------------------------

#Ques 10) Write a program in python to display number of lines in a file(“data.txt")

"""def count_lines():
    f = open("data.txt")
    count=0
    for lines in f:
        count=1
    print("no. of lines:",count)
    f.close()"""

#---------------------------------------------------------------------------------------------
#Ques 11)

"""import json

dict={
    "ID":[
    {
     "0":90,
     "1":56,
     "2":34,
     "3":96,
     "4":45
     }],
    
    "Name":[
    {
        "0":"Akash",
        "1":"Chalsea",
        "2":"Divya",
        "3":"Sajal",
        "4":"Shubham" ,
        }],
    "Marks":[
    {
        "0":81,
        "1":87,
        "2":100,
        "3":89,
        "4":78,
        }],
    "Grade":[
    {
        "0":"B",
        "1":"B",
        "2":"A",
        "3":"B",
        "4":"C"}
    ]
    }
json_string = json.dumps(dict)
print(json_string)

dict2={
    "ID":[
    {
        "0":23,
        "1":43,
        "2":12,
        "3":13,
        "4":67,
        "5":89
        }],
    "Name":[
    {
    "0":"Ram",
     "1":"Deep",
     "2":"Yash",
     "3":"Aman",
     "4":"Arjun",
     "5":"Aditya"
     }],
     "Marks":[
    {
        "0":89,
        "1":97,
        "2":45,
        "3":78,
        "4":56,
        "5":76
        }],
    "Grade":[
    {
    "0":"B",
     "1":"A",
     "2":"F",
     "3":"C",
     "4":"E",
     "5":"C"
     }]
    }
json_string = json.dumps(dict2)
print(json_string)"""


"""#To covert json to csv file.

import pandas as pd
df1= pd.read_json('File1.json')
print(df1)
df2 = pd.read_json('File2.json')
print(df2)
df = pd.concat([df1,df2])
df.to_csv('CSVdata.csv',index=False)
Output = pd.read_csv("CSVdata.csv")"""


