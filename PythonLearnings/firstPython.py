from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
import time

driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://www.google.com/")
print(driver.title)
driver.find_element(By.NAME, 'q').send_keys("Naveen Automation")
time.sleep(5)
x = driver.find_elements_by_css_selector('ul.G43f7e span')

for i in x:
    if i.text == 'naveen automation labs gatling':
        i.click()
        break

driver.close()



