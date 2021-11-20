from typing import MutableMapping
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.action_chains import ActionChains
import time

base_url="http://redmine.spanenterprises.com/redmine/login?back_url=http%3A%2F%2Fredmine.spanenterprises.com%2Fredmine%2F"
# declare and initialize driver variable
driver=webdriver.Chrome(executable_path="E:/Drivers/chromedriver.exe")
# browser should be loaded in maximized window
driver.maximize_window()
# driver should wait implicitly for a given duration, for the element under consideration to load.
# to enforce this setting we will use builtin implicitly_wait() function of our 'driver' object.
driver.implicitly_wait(10) #10 is in seconds
# to load a given URL in browser window
driver.get(base_url)
# Redmine login
driver.find_element_by_id("username").send_keys('thivi')
driver.find_element_by_id("password").send_keys('Test&123')
driver.find_element_by_name("login").click()

# Select project in Redmine
project = Select(driver.find_element_by_id('project_quick_jump_box'))
project.select_by_visible_text('Express Truck Tax')

# Go to issues
driver.find_element_by_class_name('issues').click()

# Select the query
# driver.find_element_by_link_text('Open Bugs Count - QA').click()

# Critical Filter
status = Select(driver.find_element_by_id('operators_status_id'))
status.select_by_visible_text('is not')

# status filter
driver.find_element_by_xpath("//tbody/tr[@id='tr_status_id']/td[3]/span[1]/span[1]").click()

value = Select(driver.find_element_by_id('values_status_id_1'))
Resolved = driver.find_element_by_xpath('//option[contains(text(),"Resolved")]')
Closed = driver.find_element_by_xpath("//tbody/tr[@id='tr_status_id']/td[3]/span[1]/select[1]/option[8]")
Rejected = driver.find_element_by_xpath("//option[contains(text(),'Rejected')]")

# using actionchains to select multiple options
ActionChains(driver).key_down(Keys.CONTROL).click(Resolved).key_up(Keys.CONTROL).perform()
time.sleep(2)
ActionChains(driver).key_down(Keys.CONTROL).click(Closed).key_up(Keys.CONTROL).perform()
time.sleep(2)
ActionChains(driver).key_down(Keys.CONTROL).click(Rejected).key_up(Keys.CONTROL).perform()

# adding filter
filter = Select(driver.find_element_by_id('add_filter_select'))
filter.select_by_value('tracker_id')
filter.select_by_value('priority_id')

priority = Select(driver.find_element_by_id('values_priority_id_1'))
priority.select_by_value('4')

# group by priority
driver.find_element_by_xpath("//legend[contains(text(),'Options')]").click()
group = Select(driver.find_element_by_xpath("//select[@id='group_by']"))
group.select_by_value('priority')

# Apply button
driver.find_element_by_xpath("//a[contains(text(),'Apply')]").click()

# storing Critical count
a = driver.find_element_by_class_name("count")
b = a.text

# pie chart url
driver.get('https://www.meta-chart.com/pie#/display')

# Data section
driver.find_element_by_xpath("//body/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]").click()
driver.find_element_by_class_name("form-control ng-pristine ng-untouched ng-valid").sendkeys("Critical")
driver.find_element_by_class_name("form-control ng-pristine ng-untouched ng-invalid ng-invalid-required").sendkeys(b)