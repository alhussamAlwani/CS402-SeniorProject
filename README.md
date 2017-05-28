# CS402-SeniorProject

This is a Graduation Project done by: ALHUSSAM ALWANI, Supervised by: Prof.Reyyan Yeniterzi.

This is a instruction sheet on how to compile and run the project.

First of all, I have removed all of my personal access keys and tokens, you need to have 4 different access keys to run the application:
1- Fabric.io API key (you can change it from the manifest)
2- Twitter key and secret (you can change it from LoginActivity.java and MainActivity.java)
3- Localhost Location (you can change it by creating a pagekite account, and making your localhost visible online, from AppConfig.java)
4- İTÜ NLP API key (you can change it from TextAnalyzer.java)


after successfuly obtaining all the necessary tokens and changing them, you need to have WAMPSERVER running (localhost DB), you also need to make the database visible by runnig the following command: "python pagekite.py" assuming you are on windows and you have oython 2.7 installed.

after that you need to have android studio to run the application, first, import Tweets4news inside android studio, then run the emulator (i have used GenyMotion, you can use intel's built in simulator) and press run, the application will be running on the emulator.
