import pytest
from selenium.webdriver.common.by import By
import time

@pytest.mark.usefixtures('init_driver')
class BaseTest():
    pass


class TestETT(BaseTest):

    @pytest.mark.parametrize("username, password",
                            [
                                ("thiviprakash.g+1@expressexcise.com", "Test&123"),
                                ("thiviprakash.g+2@expressexcise.com", "Test&123")
                            ]
    )
    def test_login(self, username, password):
        self.driver.get("https://etts.hvut550.com/")
        time.sleep(3)
        self.driver.find_element(By.ID, "cdnPassword").send_keys("imtesting")
        self.driver.find_element(By.ID, "btnCdnSubmit").click()
        time.sleep(3)
        self.driver.find_element(By.ID, "EmailAddress").send_keys(username)
        self.driver.find_element(By.ID, "Password").send_keys(password)