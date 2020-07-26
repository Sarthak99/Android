## Top App Recommender

  This android project builds an app that subscribes and downloads XML data from a RSS feed.  
  *PS: Project is built in java*  
  Some of the main features used in this project are:  
  * Accessing Internet over andorid  
  * Understanding the protection levels of getting system feature accesses[(android permissions)](https://developer.android.com/guide/topics/permissions/overview#normal-dangerous).  
  
  **URL:** http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml  
  We use this downloaded XML data to display as a "list of Recommended Apps".
  
  ### Phase1:
  ***  
  As part of the first phase of the project, I have built a simple listView that displays the data directly on the screen as a scrollable list with an overriden toString().  
  **Screen:**  
  <img src="https://github.com/Sarthak99/Android/blob/master/TopAppRecommender/screens/BasicList.PNG" width=250 height=500>  
  
  ### Phase2:
  ***
  In this phase I built a custom screen that beautifies the data being displayed. The main dev in this phase is to build a custom adapter that uses the [LayoutInflator](https://developer.android.com/reference/android/view/LayoutInflater) to load data from XML to views. Thee is also the usage of layout that is not the main/activity_main and how to set their reference in onPostExecute method.  
  **Screen:**  
  <img src="https://github.com/Sarthak99/Android/blob/master/TopAppRecommender/screens/CustomisedList1.PNG" width=250 height=500>
  

`ReadMe Build to be completed`  
<img src = "http://horticulture.tg.nic.in/img/work-in-progress-wip.jpg" width=220 height=200>
