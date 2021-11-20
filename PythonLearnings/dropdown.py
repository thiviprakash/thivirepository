from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as ec
from selenium.webdriver.support.ui import Select
#from Utilities import CommonFuntions as cf

# This is browser setup
driver = webdriver.Chrome()
driver.maximize_window()
wait = WebDriverWait(driver, 10)

#Login into the application
driver.get("https://etts.hvut550.com/")
driver.find_element(By.ID, "cdnPassword").send_keys("imtesting")
driver.find_element(By.ID, "btnCdnSubmit").click()

driver.find_element_by_id("EmailAddress").send_keys("thiviprakash.g+45@expressexcise.com")
driver.find_element_by_id("Password").send_keys("Test&123")
driver.find_element_by_id("btnSignIn").click()

#Explicit wait
wait.until(ec.title_contains("Dashboard"))
print(driver.title)

#Assertion
assert driver.title == "Dashboard"

driver.find_element(By.NAME, "createReturn").click()
wait.until(ec.text_to_be_present_in_element((By.XPATH, "//div[@id='form_headingPop']"), 'Create A New Tax Return'))

driver.find_element(By.XPATH, "//a[@title='Start the New Return' and @id='Create2290' and @class='orangeBtn_oval mTop15 mBot15']").click()
wait.until(ec.title_contains("Form 2290 Single Vehicle Filing - Step 1"))

def sel(ele, value):
    select = Select(ele)
    select.select_by_visible_text("2020 - 21 (Prior Tax Year)")
    

taxyear = driver.find_element(By.ID, "TaxYear")

sel(taxyear, "2020 - 21 (Prior Tax Year)")

#select.select_by_visible_text('2020 - 21 (Prior Tax Year)')

    



#driver.close()