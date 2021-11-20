from selenium import webdriver


driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://www.amazon.in/")

driver.execute_script('window.scrollBy(0,document.body.scrollHeight)')

driver.execute_script('arguments[0].scrollIntoView(true);', )