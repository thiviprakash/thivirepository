import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
#driver.maximize_window()

#Login into the application
def ETT_Staging_login():
    driver.get("https://etts.hvut550.com/")
    driver.find_element(By.ID, "cdnPassword").send_keys("imtesting")
    driver.find_element(By.ID, "btnCdnSubmit").click()

    driver.find_element_by_id("EmailAddress").send_keys("thiviprakash.g+45@expressexcise.com")
    driver.find_element_by_id("Password").send_keys("Test&123")
    driver.find_element_by_id("btnSignIn").click()

