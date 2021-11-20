import pytest
from selenium import webdriver


driver = None

def setup_module(module):
    global driver
    driver = webdriver.Firefox()
    driver.implicitly_wait(5)
    driver.get("https://www.google.com/")

def teardown_module(module):
    driver.quit()

def test_google():
    assert driver.title == 'Google'

def test_google1():
    assert driver.title == 'ABC'
