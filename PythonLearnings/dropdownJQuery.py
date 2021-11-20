from selenium import webdriver
from selenium.webdriver.android.webdriver import WebDriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as ec
import time


driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/")


driver.find_element_by_id("justAnInputBox").click()
time.sleep(5)

drop_down = driver.find_elements(By.CSS_SELECTOR, 'span.comboTreeItemTitle')

for ele in drop_down:
    print(ele.text)
    if ele.text == "choice 2":
        ele.click()

#driver.close()

