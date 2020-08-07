# wine-service

## Current State:

For now it just diplays a "Hello World"-Message

## Goal:

This project is going to be a service for handling measurements of acid, sugar, alcohol etc. for the process of creating (mainly apple) wine. Once this has been released for a first time, a corresponding angular project will be created. Initially, it is going to utilize a H2 which will later be substituted with a Postgres db.  
  
  


## Structure:

It will need two types of objects:  
1. An Object called "**Batch**", which is the initial object that gets created when starting a new batch (i.e. a new fermentation bottle).
It will have the following attributes:
    * id: _generated Id for the batch_
    * name: _name of the specific batch_
    * yeast: _name of the used yeast_
    * originCoordinates: _an array of coordinates of the origin of the fruits_
    * originDescription: _a description of the origin of the fruit_
    * productionDate: _the date when production begins_  
    
2. An Object called "**Measurement**", which holds all the information for every time a measurement was taken.
    * id: _generated Id for the measurement which must also refer to the batch it was taken from.
    * (name: if the Id can't be created in such a way that it also refers to the respective batch, another property like a distinctive name might be needed. This still needs to be researched)
    * acid: _a floating point number representing the acid level_
    * alcohol: _a floating point number representing the alcohol level_
    * sugar: _a floating point number representing the level of alcohol_
    * liters: _a floating point number representing the amount of liters_
    * sugarAdded: _a floating point number representing the amount of sugar that was added_
    * acidAdded: _a floating point number representing the amount of acid that was added_
    * currentDate: _the date the measurement was taken (not supposed to be automatically generated)_
    * taste: _a description of the taste_
    
    

## A short summary of the wine making process
It might be good to know a little about the process to understand why certain things are needed.  
After creating juice from the fruits, measurements like acid, (alcohol, ), sugar, amount of liters are taken. The juice is then poured into 4,5L-bottles. The yeast is added and then put
 in a place with no direct sunlight and stable temperatures. The fermentation usually begins within a couple of days.  
 When the excessive part of the fermentation is over. The wine is then put into a fresh bottle while leaving the yeast behind. 
At this point measuring repeats. According to the measured values sugar and/or acid is added. This process the repeats for a couple of times over the next weeks, to make the wine clearer each time.
