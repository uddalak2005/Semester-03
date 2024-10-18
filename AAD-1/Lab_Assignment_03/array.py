import random
import os

# Function to generate an array of random integers of a given size
def generate_random_array(size):
    return [random.randint(1, 10000) for _ in range(size)]

# Function to write arrays to a text file in a specified directory
def write_arrays_to_file(directory, filename):
    # Ensure the directory exists
    if not os.path.exists(directory):
        os.makedirs(directory)  # Create directory if it doesn't exist
    
    # Full path to the file
    filepath = os.path.join(directory, filename)
    
    # Sizes of arrays: 10^2, 10^3, 10^4, 10^5, 10^6
    sizes = [10**2, 10**3, 10**4]
    
    with open(filepath, 'w') as file:
        for size in sizes:
            arr = generate_random_array(size)
            # Convert array to space-separated string and write to file
            file.write(" ".join(map(str, arr)) + "\n")
    
    print(f"File saved at: {filepath}")

# Specify the directory where you want to save the file
directory = "./"  # Replace this with your desired path
filename = "input.txt"

# Generate and write the arrays to 'input.txt' in the specified directory
write_arrays_to_file(directory, filename)
