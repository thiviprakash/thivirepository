*** Settings ***

*** Variables ***

*** Keywords ***
Login to flipkart
    Input Text  xpath://input[@class='_2IX_2- VJZDxU']  9965821897
    Input Text  xpath://input[@class='_2IX_2- _3mctLh VJZDxU']  IVID2231424
    Click Button  xpath://button[@class='_2KpZ6l _2HKlqd _3AWRsL' and @type='submit']

Search product in flipkart
    Input Text  xpath://input[@class='_3704LK']  Redmi note lite 10 4GB RAM + 64GB Storage
    Click Button  xpath://button[@type='submit' and @class='L0Z3Pu']
    ${title1}=  Get Title
    Log to console  ${title1}

Verify the product spec and get the price in flipkart
    Click Element  xpath://div[contains(text(),'REDMI Note 10')]
    
    ${handles}=  Get Window Handles
    Log to console  ${handles}
    Switch Window  ${handles}[1]
   
    ${Flipkart Amount}=  Get Text  xpath://div[@class='_30jeq3 _16Jk6d']
    Set Global Variable  ${Flipkart Amount}
    Log to console  ${Flipkart Amount}

Login to amazon
    Click Link  id:nav-link-accountList
    Input Text  id:ap_email  9965821897
    Click Button  id:continue
    Input Text  id:ap_password  IVID2231424
    Click Button  id:signInSubmit

Search product in amazon
    Input Text  id:twotabsearchtextbox  Redmi note lite 10 4GB RAM + 64GB Storage
    Click Button  xpath://input[@id='nav-search-submit-button' and @type='submit']

Verify the product spec and get the price in amazon
    Click Element  xpath:(//span[@class='a-size-medium a-color-base a-text-normal'])[1]

    ${handles}=  Get Window Handles
    Switch Window  ${handles}[1]

    ${Amazon Amount}=  Get Text  id:priceblock_ourprice
    Set Global Variable  ${Amazon Amount}
    Log to console  ${Amazon Amount}

Add to amazon cart
    Click Button  id:add-to-cart-button
    