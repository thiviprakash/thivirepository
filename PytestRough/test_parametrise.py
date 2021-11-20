import pytest

@pytest.mark.parametrize("value, result", [(1,11),(2,22),(3,35)])
def test_calculation(value, result):
    assert 11*value == result