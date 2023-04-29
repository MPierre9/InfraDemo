import pandas as pd

def create_weather_df():
    # Static weather data
    weather_data = {
        "City": ["New York", "Los Angeles", "Chicago", "Houston", "Phoenix"],
        "Temperature (°C)": [25, 28, 20, 31, 34],
        "Weather": ["Sunny", "Cloudy", "Rainy", "Thunderstorm", "Clear"],
        "Humidity (%)": [50, 45, 70, 65, 25],
    }

    # Create a DataFrame using the weather data
    weather_df = pd.DataFrame(weather_data)
    return weather_df

def print_weather_df(weather_df):
    # Print the DataFrame
    print(weather_df)

if __name__ == "__main__":
    df = create_weather_df()
    print_weather_df(df)
