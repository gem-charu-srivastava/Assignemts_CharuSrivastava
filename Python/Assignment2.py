import numpy as np
import pandas as pd

print("Creating first data frame \n" )
dict1={
    "id" :['1','2','3','4','5','6'],
    "email" : ['george.bluth@reqres.in','janet.weaver@reqres.in','emma.wong@reqres.in','eve.holt@reqres.in','charles.morris@reqres.in','tracey.ramos@reqres.in'],
    "first_name" : ['George','Janet','Emma','Eve','Charles','Tracey'],
     "last_name" : ['Bluth','Weaver','Wong','Holt','Morris','Ramos']
    }
df1=pd.DataFrame(dict1)
print(df1)

print('******************************************************************************************')

print("Creating second data frame \n")

dict2={
    "id" : ['7','8','9','10','11','12'],
    "email": ['michael.lawson@reqres.in','lindsay.ferguson@reqres.in','tobias.funke@reqres.in','byron.fields@reqres.in','george.edwards@reqres.in','rachel.howell@reqres.in'],
    "first_name" :['Michael','Lindsay','Tobias','Byron','George','Rachel'],
    "last_name" :['Lawson','Ferguson','Funke','Fields','Edwards','Howell']
    }
df2=pd.DataFrame(dict2)
print(df2)

print('*****************************************************************************************')
print("Comparing both data frames \n")

df3=df1.compare(df2,align_axis=0)
print(df3)

print('*****************************************************************************************')
print("Appending both data frames \n")

df4=df1.append(df2,ignore_index=False)
print(df4)

print('*****************************************************************************************')
print("Sorting on the basis of first name \n")

df5=df4.sort_values('first_name')
print(df5)

print('******************************************************************************************')
print("Final dataframe consisting of IDs: 4-10 inclusive \n")


df6=df4.iloc[3:10]
print(df6)

ptint('*******************************************************************************************')
