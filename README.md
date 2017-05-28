# CS402-SeniorProject

TWEETS4NEWS

is an application that allows users to be able to see what other tweet about a specific news headline.

Prequisites:

Twitter Dev Account,

Fabric.io Dev Account,

İTÜ NLP Account,

Python 2.7,

Android Studio, Gradle: 2.3.2,

Android Simulator (preferably GenyMotion),

WAMPSERVER (for DB and tables),

PageKite Account.

This is a Graduation Project done by: ALHUSSAM ALWANI, Supervised by: Prof.Reyyan Yeniterzi.

This is an instruction sheet on how to compile and run the project:

First of all, I have removed all of my personal access keys and tokens, you need to have 4 different access keys to run the application:
1- Fabric.io API key (you can change it from the manifest)
2- Twitter key and secret (you can change it from LoginActivity.java and MainActivity.java)
3- Localhost Location (you can change it by creating a pagekite account, and making your localhost visible online, from AppConfig.java)
4- İTÜ NLP API key (you can change it from TextAnalyzer.java)


after successfuly obtaining all the necessary tokens and changing them, you need to have WAMPSERVER running (localhost DB), you also need to make the database visible by runnig the following command: "python pagekite.py" assuming you are on windows and you have oython 2.7 installed.

if you want to recieve updated news headlines, you can run the Crawler.py script that gets new headlines automatically.

after that you need to have android studio to run the application, first, import Tweets4news inside android studio, then run the emulator (i have used GenyMotion, you can use intel's built in simulator) and press run, the application will be running on the emulator.
