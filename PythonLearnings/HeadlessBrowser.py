from selenium import webdriver

options = webdriver.ChromeOptions()
options.headless = True
driver = webdriver.Chrome(options=options)
driver.maximize_window()

driver.get("https://www.amazon.in/")
print(driver.title)
