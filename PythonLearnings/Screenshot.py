from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.maximize_window()
action = ActionChains(driver)


driver.get("https://www.amazon.in/")
driver.get_screenshot_as_file('C:/thivirepository/PythonLearnings/firstscreenshot.png')

footer  = driver.find_element(By.CLASS_NAME, 'navFooterBackToTopText')
action.move_to_element(footer)
driver.get_screenshot_as_file('C:/thivirepository/PythonLearnings/secondscreenshot.png')


driver.close()
