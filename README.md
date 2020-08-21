# wine-service

## Current State:

For now, it just has a GET method to return a list of all (mocked) Batches and a GET method for a single Batch by Id. 

## Goal:

This project is going to be a service for handling measurements of acid, sugar, alcohol etc. for the process of creating (mainly apple) wine. Once this has been released for a first time, a corresponding angular project will be created. Initially, it is going to utilize a H2 which will later be substituted with a Postgres db.  
  
  


## Structure:

It will need three types of objects:  

1. An Object called "**Batch**", which is the initial object that gets created when starting a new batch (i.e. a new fermentation bottle).
It will have the following attributes:
    * id: _generated Id for the batch_
    * name: _name of the specific batch_
    * year: _production year_
    * yeast: _name of the used yeast_
    * fruits: _an array of the used fruits_
    * productionDate: _the date when production begins_  
    * comment: _an optional comment_
    
2. An Object called "**Origin**", which relates to a Batch object and stores the coordinates of the origin of the fruits.
    * id: _generated Id for the location_
    * batchId: _Id that refers to the Batch (Foreign Key)_
    * originCoordinates: _an array of coordinates of the origin of the fruits_
    * originDescription: _a description of the origin of the fruit_
    
3. An Object called "**Measurement**", which holds all the information for every time a measurement was taken.
    * id: _generated Id for the measurement (which must also refer to the batch it was taken from)_
    * batch_id: _the Id of the batch which the measurement belongs to (Foreign Key Constraint)_
    * year: _production year_
    * acid: _a floating point number representing the acid level_
    * alcohol: _a floating point number representing the alcohol level_
    * sugar: _a floating point number representing the level of alcohol_
    * liters: _a floating point number representing the amount of liters_
    * addedSugar: _a floating point number representing the amount of sugar that was added_
    * addedAcid: _a floating point number representing the amount of acid that was added_
    * currentDate: _the date the measurement was taken (not supposed to be automatically generated)_
    * taste: _a description of the taste_
    * comment: _an optional comment_
    
## Implementation
This section is still very limited and grows with the project. The basic structure of the api
is going to be as the following:  
``~/api/batches/year/{year}/{id}/measurements/{id}``  
  
  To get all batches or post a new batch:  
   ``~/api/batches``

 To get all batches of a certain year:  
 ``~/api/batches/year/{year}``  
   
   To get a certain batch or put/update a batch:  
    ``~/api/batches/{id}``  
      
To get the origin of or put/update a certain batch:  
``~/api/origin/{id}``  
  
  To post the origin of a new batch:  
  ``~/api/origin``  
      
To get all measurement of a certain batch or post a new one:  
 ``~/api/batches/{id}/measurements``  
   
To get a certain measurement of a certain batch or put/update:

 ``~/api/batches/{id}/measurements/{id}``  




    

## A short summary of the wine making process
It might be good to know a little about the process to understand why certain things are needed.  
After creating juice from the fruits, measurements like acid, (alcohol, ), sugar, amount of liters are taken. The juice is then poured into 4,5L-bottles. The yeast is added and then put
 in a place with no direct sunlight and stable temperatures. The fermentation usually begins within a couple of days.  
 When the excessive part of the fermentation is over. The wine is then put into a fresh bottle while leaving the yeast behind. 
At this point measuring repeats. According to the measured values sugar and/or acid is added. This process the repeats for a couple of times over the next weeks, to make the wine clearer each time.
