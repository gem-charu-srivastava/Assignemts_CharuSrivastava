#Ques1) Write a normal python program to calculate squares and cubes of [1,2,3,4,5,6,7].
#Then implement the same with multithreading without synchronization and with synchronization, And observe the time difference in all 3 codes.


import time
import threading

numbers=[1,2,3,4,5,6,7]

print("Normal python program to calculate squares and cubes \n")

start=time.time()
square=[number**2 for number in numbers]
print(square)
end=time.time()
print("Time taken to calculate square is : " , end-start)
start=time.time()
cube=[number**3 for number in numbers]
print(cube)
end=time.time()
print("Time taken to calculate cube is : " , end-start , "\n")


print(" Python program to calculate squares and cubes without synchronization \n")

def calculate_square(numbers):
    start=time.time()
    square=[number**2 for number in numbers]
    time.sleep(1)
    print(square)
    end=time.time()
    print("Time taken to calculate cube is : " , end-start)
    
def calculate_cube(numbers):
    start=time.time()
    cube=[number**3 for number in numbers]
    time.sleep(1)
    print(cube)
    end=time.time()
    print("Time taken to calculate cube is : " , end-start)



if __name__ == '__main__':
   t1 = threading.Thread(target=calculate_square,args=[[1,2,3,4,5,6,7]])
   t2 = threading.Thread(target=calculate_cube, args=[[1,2,3,4,5,6,7]])
   t1.start()
   t2.start()
   t1.join()
   t2.join()

   

   
print(" Python program to calculate squares and cubes with synchronization \n")

def taskExecution(lock,s):
    if s == "squares":
        lock.acquire()
        calculate_square(numbers)
        lock.release()
    elif s=='cubes':
        lock.acquire()
        calculate_cube(numbers)
        lock.release()



if __name__ == '__main__':
    lock = threading.Lock()
    t1 = threading.Thread(target=taskExecution, args=[lock,'squares'])
    t2 = threading.Thread(target=taskExecution, args=[lock,'cubes'])
    t1.start()
    t2.start()
    t1.join()
    t2.join()


#Ques2) Write a Python program to remove the parenthesis area in a string.
#   Sample data:["example (.in)", "w3resource", "github (.com)", "stackoverflow (.us1)"]
#   Expected Output:
#   example
#   w3resource
#   github
#   stackoverflow

import re
Sample_data=["example (.in)", "w3resource", "github (.com)", "stackoverflow (.us1)"]
for each in Sample_data:
    Sample_data_2= Sample_data[Sample_data.index(each)]
    Sample_data_2=re.sub("[\(\[].*?[\])]","",each)
    print(Sample_data_2)


#Ques 3)Write a python program to hit GET api:https://restcountries.com/v3.1/alpha/pe and print:

#a. All 3 languages with full names.

#b. Capital, area, population.

import requests
response = requests.get('https://restcountries.com/v3.1/alpha/pe')
print(response.status_code)
my_dict=response.json()[0]
for item in my_dict['languages']:
    print(item+"->"+my_dict['languages'][item])

print("\nCapital is: ",my_dict['capital'][0])
print("\nTotal area: ",my_dict['area'])
print("\nTotal population: ",my_dict['population'])

    

