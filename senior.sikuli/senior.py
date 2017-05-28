import random

#Stopping HotKey
running = True

def runHotkey(event):
    global running
    running = False

Env.addHotkey(Key.F1, KeyModifier.CTRL, runHotkey)

#List Of Images
AppList = []

emailField = "1496011059869.png"
AppList.append(emailField)
passField = "passField.png"
AppList.append(passField)
loginField = "loginField.png"
AppList.append(loginField)
signUpField = "signUpField.png"
AppList.append(signUpField)
fullNameField = "fullNameField.png"
AppList.append(fullNameField)
emailField2 = "emailField2.png"
AppList.append(emailField2)
passField2 = "passField2.png"
AppList.append(passField2)
registerField = "registerField.png"
AppList.append(registerField)
logMeInField = "logMeInField.png"
AppList.append(logMeInField)
logoutField = "logoutField.png"
AppList.append(logoutField)
signInWithTwitter = "signInWithTwitter.png"
AppList.append(signInWithTwitter)
authorizeAppField = "authorizeAppField.png"
AppList.append(authorizeAppField)
hurriyet = Pattern("hurriyet.png").targetOffset(-1,51)
AppList.append(hurriyet)
cumhuriyet = Pattern("cumhuriyet.png").targetOffset(-6,55)
AppList.append(cumhuriyet)
anayurt = Pattern("anayurt.png").targetOffset(-3,58)
AppList.append(anayurt)
star = Pattern("star.png").targetOffset(-6,51)
AppList.append(star)
cnnTurk = Pattern("cnnTurk.png").targetOffset(0,62)
AppList.append(cnnTurk)
yenisafak = Pattern("yenisafak.png").targetOffset(-2,49)
AppList.append(yenisafak)
sabah = Pattern("sabah.png").targetOffset(0,54)
AppList.append(sabah)
aksam = Pattern("aksam.png").targetOffset(-2,52)
AppList.append(aksam)
dw = Pattern("dw.png").targetOffset(-5,54)
AppList.append(dw)
euroNews = Pattern("euroNews.png").targetOffset(-2,55)
AppList.append(euroNews)
ajHaber = Pattern("ajHaber.png").targetOffset(2,54)
AppList.append(ajHaber)
aHaber = Pattern("aHaber.png").targetOffset(7,58)
AppList.append(aHaber)
aa = Pattern("aa.png").targetOffset(-4,62)
AppList.append(aa)
gg = Pattern("gg.png").targetOffset(-3,57)
AppList.append(gg)


while running: 
    randonNum = random.randint(0, len(AppList) - 1)
    print randonNum
    if exists(AppList[randonNum]):
        click(AppList[randonNum])
    else:
        continue
