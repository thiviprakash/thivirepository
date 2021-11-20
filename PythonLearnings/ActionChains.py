from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://www.amazon.in/")

action = ActionChains(driver)

sign_in = driver.find_element(By.ID, "nav-link-accountList")

action.move_to_element(sign_in).perform()

dash_img = driver.find_element(By.XPATH, "//img[@alt='Holi']")
search_box = driver.find_element(By.ID, "twotabsearchtextbox")

action.drag_and_drop(dash_img, search_box).perform()


