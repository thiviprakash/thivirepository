from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
import time

driver = webdriver.Chrome()

driver.get("https://etts.hvut550.com/")
driver.find_element(By.ID, "cdnPassword").send_keys("imtesting")
driver.find_element(By.ID, "btnCdnSubmit").click()

driver.find_element_by_id("EmailAddress").send_keys("thiviprakash.g+45@expressexcise.com")
driver.find_element_by_id("Password").send_keys("Test&123")
driver.find_element_by_id("btnSignIn").click()
time.sleep(3)
heading = driver.find_element(By.ID, "form_heading")
assert heading.text == 'Dashboard'