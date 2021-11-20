***Settings***
Library  SeleniumLibrary
Resource  ../Resources/resources1.robot

***Variables***
${Browser}  Chrome
${flipkart}  https://www.flipkart.com/
${amazon}  https://www.amazon.in/


***Test Cases***
TC_001 Check the price of a product in flipkart
    Open Browser  ${flipkart}  ${Browser}
    Maximize Browser Window
    Set Selenium Speed  1 seconds

    Login to flipkart
    Search product in flipkart
    Verify the product spec and get the price in flipkart
    Close Browser

TC_002 Check the price of a product in Amazon
    Open Browser  ${amazon}  ${Browser}
    Maximize Browser Window
    Set Selenium Speed  1 seconds

    Login to amazon
    Search product in amazon
    Verify the product spec and get the price in amazon
    Close Browser

TC_003 Compare the price between Flipkart and Amazon
    Run Keyword If  '${Flipkart Amount}' > '${Amazon Amount}'   Log to console  Amazon is cheaper
        Open Browser  ${amazon}  ${Browser}
        Maximize Browser Window
        Set Selenium Speed  1 seconds

        Login to amazon
        Search product in amazon
        Verify the product spec and get the price in amazon
        Add to amazon cart
 
    Run Keyword If  '${Flipkart Amount}' < '${Amazon Amount}'   Log to console  Flipkart is cheaper



