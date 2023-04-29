import pandas as pd
from weather_app import create_weather_df

def test_create_weather_df():
    weather_df = create_weather_df()
    
    assert isinstance(weather_df, pd.DataFrame), "The result should be a DataFrame."
    assert len(weather_df) == 5, "The DataFrame should have 5 rows."
    assert list(weather_df.columns) == ["City", "Temperature (°C)", "Weather", "Humidity (%)"], "The column names should match the provided data."
