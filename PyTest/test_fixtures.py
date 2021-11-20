import pytest
from selenium import webdriver

driver = None

@pytest.fixture(scope='module')
def init_driver():
    global driver
    driver = webdriver.Firefox()
    driver.implicitly_wait(5)
    driver.get("https://www.google.com/")

    yield
    driver.quit()

def test_google(init_driver):
    assert driver.title == 'Google'

def test_google1(init_driver):
    assert driver.title == 'ABC'

