import pytest

@pytest.mark.usefixtures('init_driver')
class BaseTest:
    pass

class Test_Google(BaseTest):

    def test_google_title(self):
        self.driver.get("https://www.google.com/")
        assert self.driver.title == "Google"

    def test_google_url(self):
        self.driver.get("https://www.google.com/")
        assert self.driver.current_url == "https://www.google.com/"